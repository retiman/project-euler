#lang racket

; Provides many of the functions already defined in racket/number-theory,
; but using that is possibly against the 'spirit' of Project Euler.
(provide coprime?
         digits
         divides?
         divisors
         divisors*
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
         next-prime
         next-primes
         next-primes*
         nth-prime
         ord
         phi
         prime?
         prime-factors
         relatively-prime?
         sigma
         sigma*
         tau
         tau*
         totient
         σ
         τ
         φ)

(require "core.rkt")

; Returns true if two numbers are coprime; false otherwise.
;
; In number theory, two integers a and b are said to be relatively prime,
; mutually prime, or coprime (also spelled co-prime) if the only positive
; integer that divides both of them is 1. In other words, their greatest
; common divisor is 1.
;
; See http://en.wikipedia.org/wiki/Coprime
(define (coprime? m n)
  (= (gcd m n) 1))

; Returns the number of digits in a number n.
(define (digits n)
  (add1 (floor (log10 n))))

; Returns #t if m divides n; false otherwise.
(define (divides? m n)
  (zero? (modulo n m)))

; Returns the divisors of n, including itself. This method uses a naive
; algorithm, but memoizes the result.
(define-memo (divisors n)
  (let* ((xs (filter (curryr divides? n) (range 2 (add1 (integer-sqrt n)))))
         (ys (map (curry quotient n) xs)))
    (set-union (set 1 n) (list->set xs) (list->set ys))))

; Returns the divisors of n, excluding itself.
(define (divisors* n)
  (set-remove (divisors n) n))

; Returns the factorial of n.
;
; See https://en.wikipedia.org/wiki/Factorial
(define (factorial n)
  (define (factorial* i acc)
    (if (= i 0)
      acc
      (factorial* (sub1 i) (* i acc))))
  (factorial* n 1))

; Returns true if n is a factorion; false otherwise.
;
; A factorion is a natural number that equals the sum of the factorials of
; its decimal digits. For example, the factorion of 145 = 1! + 4! + 5!.
;
; See http://en.wikipedia.org/wiki/Factorion
(define (factorion? n)
  (= n (foldr + 0 (map factorial (integer->list n)))))

; The fibonacci sequence as a stream. This stream begins with a 0.
;
; TODO: Convert this to an SRFI/41 stream.
;
; See https://en.wikipedia.org/wiki/Fibonacci_number
(define fibs
  (letrec ((f (λ (a b) (stream-cons a (f b (+ a b))))))
    (f 0 1)))

; Returns the the base b logarithm of a.
;
; See https://en.wikipedia.org/wiki/Logarithm
(define (logarithm b a)
  (/ (log a) (log b)))

; Returns the base 2 logarithm of a.
(define (log2 a)
  (logarithm 2 a))

; Returns the base 10 logarithm of a.
(define (log10 a)
  (logarithm 10 a))

; Returns the residue when raising b to the eth power and dividing by m.
;
; See https://en.wikipedia.org/wiki/Modular_exponentiation
(define (modular-expt b e m)
  (define (loop a b e)
    (if (<= e 0)
      a
      (let ((t (if (= (bitwise-and e 1) 1) (modulo (* a b) m) a)))
        (loop t (modulo (* b b) m) (arithmetic-shift e -1)))))
  (loop 1 b e))

; Returns the residue when raising b to the bth power, e times, and dividing
; by m.
;
; See https://en.wikipedia.org/wiki/Tetration
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

; Returns the next prime after n.
(define (next-prime n)
  (cond
    ((= n 0) 2)
    ((= n 1) 2)
    ((= n 2) 3)
    (else (let ((n* (if (odd? n) (+ n 2) (add1 n))))
            (if (prime? n*)
              n*
              (next-prime n*))))))

; Returns the next limit primes after n.
(define (next-primes n limit)
  (define (loop m limit)
    (if (zero? limit)
      empty
      (let ((p (next-prime m)))
        (cons p (loop p (sub1 limit))))))
  (loop n limit))

; Returns the next primes less than or equal to limit after n.
(define (next-primes* n limit)
  (define (loop m)
    (let ((p (next-prime m)))
      (if (> p limit)
        empty
        (cons p (loop p)))))
  (loop n))

; Returns the nth prime.
(define (nth-prime n)
  (for/fold ((p 2))
            ((k (in-range n)))
    (next-prime p)))

; Returns the multiplicative order of a modulo n. This is the smallest
; positive integer k such that (= (modular-expt a k n) 1).
;
; https://en.wikipedia.org/wiki/Multiplicative_order
(define-memo (ord a m)
  (unless (coprime? a m) (raise-argument-error 'a "(= (gcd a m) 1)" (cons a m)))
  (let ((ds (sort (set->list (divisors (φ m))) <)))
    (first (dropf ds (λ (n) (> (modular-expt a n m) 1))))))

; Returns true if the n is prime; false otherwise.
(define (prime? n)
  (if (and (exact? n) (positive? n))
    (or (= n 2) (= (set-length (divisors n)) 2))
    #f))

; Returns the prime factors of n as a set.
(define (prime-factors n)
  (set-filter prime? (divisors n)))

; Returns the sum of divisors of n.
;
; See http://en.wikipedia.org/wiki/Divisor_function
(define (sigma n)
  (for/sum ((i (divisors n))) i))

; Returns the sum of divisors of n, excluding itself.
;
; See http://en.wikipedia.org/wiki/Divisor_function
(define (sigma* n)
  (- (sigma n) n))

; Returns the number of divisors of n.
;
; See http://en.wikipedia.org/wiki/Divisor_function
(define (tau n)
  (set-length (divisors n)))

; Returns the number of divisors of n, excluding itself.
;
; See http://en.wikipedia.org/wiki/Divisor_function
(define (tau* n)
  (sub1 (tau n)))

; Returns the totient of n. This is the number of positive integer less than or
; equal to n and coprime to n.
;
; See http://en.wikipedia.org/wiki/Totient
(define (totient n)
  (cond ((= n 1) 0)
  (else (* n (for/product ((p (prime-factors n)))
                          (- 1 (/ 1 p)))))))

(define lb log2)
(define ld log2)
(define lg log10)
(define ln log)
(define phi totient)
(define relatively-prime? coprime?)
(define σ sigma)
(define τ tau)
(define φ totient)
