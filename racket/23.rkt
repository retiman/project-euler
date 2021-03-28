#! /usr/bin/env racket
#lang racket
(require rackunit)
(require "lib/number-theory.rkt")


(define limit 28123)

(define numbers
  (list->vector (range (add1 limit))))

(define abundants
  (list->vector (filter (λ (n) (> (sigma* n) n)) (range 1 (add1 limit)))))

(for* ((i (range (vector-length abundants)))
       (j (range i (vector-length abundants))))
  (let ((n (+ (vector-ref abundants i) (vector-ref abundants j))))
    (when (<= n limit)
      (vector-set! numbers n 0))))

(define result
  (for/sum ((n numbers) #:when (not (zero? n))) n))

(displayln result)
(check-equal? result 4179871)
