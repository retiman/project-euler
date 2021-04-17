#lang racket
(require rackunit)


(define result
  (for/sum ((n (in-range 1000))
            #:when (or (zero? (modulo n 3)) (zero? (modulo n 5))))
    n))

(displayln result)
(check-equal? result 233168)
