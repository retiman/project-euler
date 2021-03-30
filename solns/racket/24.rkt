#!/usr/bin/env racket
#lang racket
(require rackunit)


(define (list->number lst)
  ((compose string->number
            (curry apply string-append)
            (curry map number->string))
   lst))

(define result
  ((compose (curryr vector-ref (sub1 1000000))
            list->vector
            (curryr sort <)
            (curry map list->number)
            permutations)
     (range 10)))

(displayln result)
(check-equal? result 2783915460)
