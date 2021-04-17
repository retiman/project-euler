#lang racket
(require rackunit)
(require "lib/number-theory.rkt")


; Search around the radius of (sqrt 1e7), and generate all possible semi-prime
; pairs "around" that vicinity.
(define limit (inexact->exact 1e7))

(define limit* (* 2 (add1 (integer-sqrt limit))))

(define ps 
  (filter (curryr < limit*) (file->list "../data/primes.txt")))

(define bs
  (combinations ps 2))

; This is a special totient function that optimizes the computation of totient
; for a semi-prime whose factors are p and q.
;
; For a prime number, the totient is simply (sub1 p).  Because the totient is
; a multiplicative function, (phi (* p q)) is the same as (* (phi p) (phi q)).
(define (totient* p q)
  (* (sub1 p) (sub1 q)))

; Checks if two positive integers' digits are permutations of each other.
(define (digits-permutation? m n)
  (let ((m* (sort (number->list m) <))
        (n* (sort (number->list n) <)))
    (equal? m* n*)))

(define (digits-permutation*? pair)
  (let* ((m (car pair))
         (n (cdr pair)))
    (digits-permutation? m n)))

; Defines pair of totient(n) and the prime factors of n (p and q).
(define (make-totient-to-semi-prime-pair factors)
  (let* ((p (car factors))
         (q (cadr factors))
         (n (* p q)))
    (cons (totient* p q) n)))

; Filter out semiprimes > limit that aren't digit permutations with the totient.
(define (within-limit? pair)
  (let ((n (cdr pair)))
    (<= n limit)))

(define totient-to-semi-prime-pairs
  ((compose (curry filter digits-permutation*?)
            (curry filter within-limit?)
            (curry map make-totient-to-semi-prime-pair))
    bs))

; Of the candidates that are digit permutations and where the ratio is at the
; max, find the largest value of phi(n) * n.
(define min-ratio limit)
(define result 0)

(for ((pair totient-to-semi-prime-pairs))
  (let* ((phi (car pair))
         (n (cdr pair))
         (ratio (/ n phi)))
    (when (< ratio min-ratio)
      (set! min-ratio ratio)
      (set! result n))))

(displayln result)
(check-equal? result 8319823)
