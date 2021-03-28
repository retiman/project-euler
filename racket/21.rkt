#! /usr/bin/env racket
#lang racket
(require rackunit)
(require "lib/number-theory.rkt")


(define result
  (for/sum ((a (in-range 2 10001)))
    (let ((b (sigma* a)))
      (if (and (> a b) (= (sigma* b) a))
        (+ a b)
        0))))

(displayln result)
(check-equal? result 31626)
