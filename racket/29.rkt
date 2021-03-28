#! /usr/bin/env racket
#lang racket
(require rackunit)
(require "lib/set.rkt")


(define result
  (set-length
    (for*/set ((a (in-range 2 101))
              (b (in-range 2 101)))
      (expt a b))))

(displayln result)
(check-equal? result 9183)
