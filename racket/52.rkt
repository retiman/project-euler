#!/usr/bin/env racket
#lang racket
(require rackunit)
(require srfi/41)
(require "lib/core.rkt")


(define (same-digits? a b . more)
  (let* ((xs (append (list a) (list b) more))
         (ys (map integer->list xs)))
    (andmap (curry set=? (car ys)) (cdr ys))))

(define (products n)
  (map (curry * n) (range 1 (add1 6))))

(define xs
  (stream-map products (stream-from 1)))

(define ys
  (stream-drop-while (lambda (n) (not (apply same-digits? n))) xs))

(define result (car (stream-car ys)))

(displayln result)
(check-equal? result 142857)
