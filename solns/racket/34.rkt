#lang racket
(require rackunit)
(require "lib/core.rkt")
(require "lib/number-theory.rkt")


(define limit (for/sum ((i (in-range 1 10)))
                (log10 i)))

(define max-digits
  (letrec ((loop (lambda (d)
                   (if (< (- d 1 (log10 d)) limit)
                     (loop (add1 d))
                     (sub1 d)))))
    (loop 1)))

(define max-factorion
  (* (factorial 9) max-digits))

(define result
  (for/sum ((n (range 3 (add1 max-factorion)))
            #:when (factorion? n))
    n))

(displayln result)
(check-equal? result 40730)
