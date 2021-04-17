#lang racket
(require rackunit)
(require srfi/41)
(require "lib/number-theory.rkt")


(define result
  ((compose (curry apply +)
            (curry filter even?)
            stream->list
            (curry stream-take-while (curryr < 4000000)))
     fibs))

(displayln result)
(check-equal? result 4613732)
