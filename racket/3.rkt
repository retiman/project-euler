#!/usr/bin/env racket
#lang racket
(require rackunit)
(require "lib/number-theory.rkt")


(define result
  (apply max (set->list (prime-factors 600851475143))))

(displayln result)
(check-equal? result 6857)
