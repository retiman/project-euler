#!/usr/bin/env racket
#lang racket


(define limit
  (string->number (vector-ref (current-command-line-arguments) 0)))

; Sieve from RosettaCode.
; See https://rosettacode.org/wiki/Sieve_of_Eratosthenes#Racket
(define (sieve n)
  (define primes (make-vector (add1 n) #t))
  (for* ((i (in-range 2 (add1 n)))
         #:when (vector-ref primes i)
         (j (in-range (* i i) (add1 n) i)))
    (vector-set! primes j #f))
  (for/list ((n (in-range 2 (add1 n)))
             #:when (vector-ref primes n))
    n))

(for ((p (sieve limit)))
  (displayln p))
