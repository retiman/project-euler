; Problem #16: https://projecteuler.net/problem=16

(require "lib/core.rkt")

(displayln (for/sum ((c (number->string (expt 2 1000)))) (char->integer* c)))
