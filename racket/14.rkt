#!/usr/bin/env racket
#lang racket
(require rackunit)
(require "lib/core.rkt")


(define-memo (collatz-length n)
  (define (loop i acc)
    (cond ((= i 1) acc)
          ((even? i) (loop (/ i 2) (add1 acc)))
          ((odd? i) (loop (+ 1 (* 3 i)) (add1 acc)))))
  (loop n 0))

(define (number->pair n)
  (cons (collatz-length n) n))

(define result
  (let* ((n 1000000)
         (h (apply make-hash (list (map number->pair (range 1 n)))))
         (k (apply max (hash-keys h))))
    (hash-ref h k)))

(displayln result)
(check-equal? result 837799)
