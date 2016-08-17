; Problem #1: https://projecteuler.net/problem=1

(displayln
  (for/sum ((n (in-range 1000))
            #:when (or (zero? (modulo n 3)) (zero? (modulo n 5))))
    n))
