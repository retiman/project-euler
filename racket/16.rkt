#! /usr/bin/env racket
#lang racket
(require rackunit)
(require "lib/core.rkt")


(define result
  (for/sum ((c (number->string (expt 2 1000)))) (char->integer* c)))

(displayln result)
(check-equal? result 1366)
