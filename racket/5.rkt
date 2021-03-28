#!/usr/bin/env racket
#lang racket
(require rackunit)


(define result (apply lcm (range 1 20)))

(displayln result)
(check-equal? result 232792560)
