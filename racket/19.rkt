#!/usr/bin/env racket
#lang racket
(require rackunit)
(require "lib/number-theory.rkt")


(define days-per-month
  (vector 31 28 31 30 31 30 31 31 30 31 30 31))

(define (days-in-month month year)
  (let ((days (vector-ref days-per-month month)))
    (if (and (= month 1) (divides? 4 year))
      (add1 days)
      days)))

(define days 2)

(define result
  (for*/sum ((year (in-range 1901 2001))
            (month (in-range 0 12)))
    (let* ((d (days-in-month month year)))
      (set! days (+ days (modulo d 7)))
      (if (divides? 7 days) 1 0))))


(displayln result)
(check-equal? result 171)
