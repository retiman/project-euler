#!/usr/bin/env racket
#lang racket
(require rackunit)
(require "lib/core.rkt")
(require "lib/number-theory.rkt")


(define result
  (letrec ((loop (lambda (n i) (if (> (tau n) 500) n (loop (+ n i) (add1 i))))))
    (loop 3 3)))

(displayln result)
(check-equal? result 76576500)
