#lang racket
(require rackunit)
(require "lib/core.rkt")
(require "lib/number-theory.rkt")


(define result
  (for/last ((i (in-naturals))
             (n fibs)
             #:break (>= (count-digits n) 1000))
    (add1 i)))

(displayln result)
(check-equal? result 4782)
