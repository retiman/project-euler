#! /usr/bin/env racket
#lang racket
(require rackunit)


(define result (first (drop (file->list "../data/primes.txt") 10000)))

(displayln result)
(check-equal? result 104743)
