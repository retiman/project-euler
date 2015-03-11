#lang racket

(provide coprime?
         divides?
         divisors
         factorial
         modular-expt
         tau
         sigma
         ord
         prime?
         prime-factors
         totient
         phi
         σ
         τ
         φ)

(require "core.rkt")

(define (coprime? m n)
  (= (gcd m n) 1))

(define (divides? m n)
  (zero? (modulo m n)))

(define/memo (divisors n)
  (let* ((xs (filter (curry divides? n) (range 2 (add1 (integer-sqrt n)))))
         (ys (map (curry quotient n) xs)))
    (set-union (set 1 n) (list->set xs) (list->set ys))))

(define (factorial n)
  (define (factorial* i acc)
    (if (= i 0)
      acc
      (factorial* (sub1 i) (* i acc))))
  (factorial* n 1))

(define (modular-expt b e m)
  (define (f a b e)
    (if (<= e 0)
      a
      (let ((t (if (= (bitwise-and e 1) 1) (modulo (* a b) m) a)))
        (f t (modulo (* b b) m) (arithmetic-shift e -1)))))
  (f 1 b e))

(define/memo (ord a m)
  (unless (coprime? a m) (raise-argument-error 'a "coprime to m" a))
  (let ((ds (set->list (divisors (φ m)))))
    (first (dropf ds (λ (n) (> (modular-expt a n m) 1))))))

(define (prime? n)
  (or (= n 2) (= (set-length (divisors n)) 2)))

(define (prime-factors n)
  (filter prime? (set->list (divisors n))))

(define (sigma n)
  (for/sum ((i (divisors n))) i))

(define (tau n)
  (set-length (divisors n)))

(define (totient n)
  (cond ((= n 1) 0)
  (else (* n (for/product ((p (prime-factors n)))
                          (- 1 (/ 1 p)))))))

(define phi totient)
(define σ sigma)
(define τ tau)
(define φ totient)
