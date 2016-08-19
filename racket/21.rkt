; Problem #21: https://projecteuler.net/problem=21

(require "lib/number-theory.rkt")

(displayln
  (for/sum ((a (in-range 2 10001)))
    (let ((b (sigma* a)))
      (if (and (> a b) (= (sigma* b) a))
        (+ a b)
        0))))
