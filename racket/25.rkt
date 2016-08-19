; Problem #25: https://projecteuler.net/problem=25

(require "lib/core.rkt")
(require "lib/number-theory.rkt")

(displayln
  (for/last ((i (in-naturals))
             (n fibs)
             #:break (>= (digits n) 1000))
    (add1 i)))
