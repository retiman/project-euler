#lang racket

; Provides many of the functions already defined in racket/number-theory,
; but using that is possibly against the 'spirit' of Project Euler.
(provide coprime?
         divides?
         divisors
         factorial
         factorion?
         fibs
         lb
         ld
         lg
         ln
         log2
         log10
         logarithm
         modular-expt
         modular-tetn
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

(define-memo (divisors n)
  (let* ((xs (filter (curry divides? n) (range 2 (add1 (integer-sqrt n)))))
         (ys (map (curry quotient n) xs)))
    (set-union (set 1 n) (list->set xs) (list->set ys))))

(define (divisors* n)
  (set-remove (divisors n) n))

(define (factorial n)
  (define (factorial* i acc)
    (if (= i 0)
      acc
      (factorial* (sub1 i) (* i acc))))
  (factorial* n 1))

(define (factorion? n)
  (= n (foldr + 0 (map factorial (integer->list* n)))))

(define fibs
  (letrec ((f (λ (a b) (stream-cons a (f b (+ a b))))))
    (f 0 1)))

(define (logarithm b a)
  (/ (log a) (log b)))

(define (log2 a)
  (logarithm 2 a))

(define (log10 a)
  (logarithm 10 a))

(define (modular-expt b e m)
  (define (loop a b e)
    (if (<= e 0)
      a
      (let ((t (if (= (bitwise-and e 1) 1) (modulo (* a b) m) a)))
        (loop t (modulo (* b b) m) (arithmetic-shift e -1)))))
  (loop 1 b e))

(define (modular-tetn b e m)
  (define (f b e m)
    (let* ((o (ord b m))
           (t (modular-tetn b (sub1 e) o)))
      (modular-expt b t m)))
  (define (g b e m d)
    (let* ((n (quotient m d))
           (t (modular-tetn b e n))
           (i (modular-expt b (sub1 (totient n)) n))
           (u (modulo (* t i) n)))
      (modulo (* b u) m)))
  (let ((d (gcd b m)))
    (cond ((= m 1) 0)
          ((= e 1) (modulo b m))
          ((= d 1) (f b e m))
          ((= d m) 0)
          (else (g b e m d)))))

(define (next-prime n)
  (cond
    ((= n 0) 2)
    ((= n 1) 2)
    ((= n 2) 3)
    (else (let ((n* (if (odd? n) (+ n 2) (add1 n))))
            (if (prime? n*)
              n*
              (next-prime n*))))))

(define (next-primes n limit)
  (define (loop m limit)
    (if (zero? limit)
      empty
      (let ((p (next-prime m)))
        (cons p (loop p (sub1 limit))))))
  (loop n limit))

(define (next-primes* n limit)
  (define (loop m limit)
    (let ((p (next-prime m)))
      (if (> p limit)
        empty
        (cons p (loop p (sub1 limit))))))
  (loop n limit))

(define (nth-prime n)
  (for/fold ((p 2))
            ((k (in-range n)))
    (next-prime p)))

(define-memo (ord a m)
  (unless (coprime? a m) (raise-argument-error 'a "(= (gcd a m) 1)" (cons a m)))
  (let ((ds (set->list (divisors (φ m)))))
    (first (dropf ds (λ (n) (> (modular-expt a n m) 1))))))

(define (prime? n)
  (if (and (exact? n) (positive? n))
    (or (= n 2) (= (set-length (divisors n)) 2))
    #f))

(define (prime-factors n)
  (filter prime? (set->list (divisors n))))

(define (sigma n)
  (for/sum ((i (divisors n))) i))

(define (sigma* n)
  (- (sigma n) n))

(define (tau n)
  (set-length (divisors n)))

(define (totient n)
  (cond ((= n 1) 0)
  (else (* n (for/product ((p (prime-factors n)))
                          (- 1 (/ 1 p)))))))

(define lb log2)
(define ld log2)
(define lg log10)
(define ln log)
(define phi totient)
(define σ sigma)
(define τ tau)
(define φ totient)
