(require "lib/core.rkt")
(require "lib/number-theory.rkt")

(define (number-length n)
  (string-length (number->string n)))

(displayln
  (for/last ((i (in-naturals))
             (n fibs)
             #:break (>= (number-length n) 1000))
    (add1 i)))
