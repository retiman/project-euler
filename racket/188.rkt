#! /usr/bin/env racket
#lang racket
(require rackunit)
(require "lib/number-theory.rkt")


(define result (modular-tetn 1777 1855 100000000))

(displayln result)
(check-equal? result 95962097)
