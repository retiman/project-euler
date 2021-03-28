#!/usr/bin/env racket
#lang racket
(require rackunit)
(require srfi/41)
(require "lib/core.rkt")


(define (digital-sum-5 n)
  (for/sum ((c (string->list (number->string n))))
    (expt (char->integer* c) 5)))

(define limit
  (let* ((x (expt 9 5))
         (s (stream-take-while (lambda (n) (<= (expt 10 (sub1 n)) x))
                               (stream-from 0))))
    (* (stream-length s) x)))

(define result
  (for/sum ((i (range 10 limit))
            #:when (= i (digital-sum-5 i)))
    i))

(displayln result)
(check-equal? result 443839)
