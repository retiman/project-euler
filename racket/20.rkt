; Problem #20: https://projecteuler.net/problem=20

(require "lib/core.rkt")
(require "lib/number-theory.rkt")

(displayln
  (for/sum ((c (number->string (factorial 100))))
    (char->integer* c)))
