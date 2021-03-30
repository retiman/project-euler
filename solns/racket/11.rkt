#!/usr/bin/env racket
#lang racket
(require math/matrix)
(require rackunit)


(define (line->vector line)
  (for/vector ((e (regexp-split #px" " line)))
    (string->number e)))

(define m
  (vector*->matrix
    (for/vector ((line (file->lines "../data/11.txt")))
      (line->vector line))))

(define (→ i j)
  (with-handlers
    ((exn:fail? (const 0)))
    (for/product ((k (in-range 4)))
                  (matrix-ref m i (+ j k)))))

(define (↑ i j)
  (with-handlers
    ((exn:fail? (const 0)))
    (for/product ((k (in-range 4)))
                  (matrix-ref m (+ i k) j))))

(define (↗ i j)
  (with-handlers
    ((exn:fail? (const 0)))
    (for/product ((k (in-range 4)))
                  (matrix-ref m (- i k) (+ j k)))))

(define (↘ i j)
  (with-handlers
    ((exn:fail? (const 0)))
    (for/product ((k (in-range 4)))
                  (matrix-ref (+ i k) (+ j k)))))

(define result
  (apply max
    (flatten
      (for*/list ((i (in-range 20))
                  (j (in-range 20)))
        (list (→ i j) (↑ i j) (↗ i j) (↘ i j))))))

(displayln result)
(check-equal? result 70600674)
