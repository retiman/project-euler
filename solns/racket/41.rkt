#!/usr/bin/env racket
#lang racket
(require rackunit)
(require "lib/core.rkt")
(require "lib/number-theory.rkt")

(define xs
  (map list->integer (permutations (range 1 8))))

(define result
  (apply max (filter prime? xs)))

(displayln result)
(check-equal? result 7652413)
