#!/usr/bin/env racket
#lang racket
(require rackunit)
(require "lib/core.rkt")

(define data

  (apply string-append (file->lines "../data/8.txt")))

(define (char-at data i)
  (char->integer* (string-ref data i)))

(define result
  (apply max
    (for/list ((i (range 1 (- (string-length data) 4))))
      (apply * (map (curry char-at data) (range i (+ i 5)))))))

(displayln result)
(check-equal? result 40824)
