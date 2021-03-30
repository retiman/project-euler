#!/usr/bin/env racket
#lang racket
(require rackunit)
(require "lib/core.rkt")
(require "lib/number-theory.rkt")


(define result
  (for/sum ((c (number->string (factorial 100))))
    (char->integer* c)))

(displayln result)
(check-equal? result 648)
