#!/usr/bin/env racket
#lang racket
(require rackunit)


(define result
  (apply + (filter (curryr < 2000000) (file->list "../data/primes.txt"))))

(displayln result)
(check-equal? result 142913828922)
