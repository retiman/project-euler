#!/usr/bin/env racket
#lang racket
(require rackunit)
(require "lib/core.rkt")
(require "lib/number-theory.rkt")


(define limit (for/sum ((i (in-range 1 10)))
                (log10 i)))

(define max-digits
  (letrec ((loop (lambda (digits)
                   (if (< (- digits 1 (log10 digits)) limit)
                     (loop (add1 digits))
                     (sub1 digits)))))
    (loop 1)))

(define max-factorion
  (* (factorial 9) max-digits))

(define result
  (for/sum ((n (range 3 (add1 max-factorion)))
            #:when (factorion? n))
    n))

(displayln result)
(check-equal? result 40730)
