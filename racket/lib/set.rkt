#lang racket

(provide set-filter
         set-length)

(define (set-filter pred? s)
  (for/set ((e s) #:when (pred? e)) e))

(define (set-length s)
  (sequence-length s))
