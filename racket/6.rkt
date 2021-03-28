#!/usr/bin/env racket
#lang racket
(require rackunit)


(define result
  (let* ((a (apply + (map (curryr expt 2) (range 1 101))))
         (b (apply + (range 1 101))))
    (- (* b b) a)))

(displayln result)
(check-equal? result 25164150)
