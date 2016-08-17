#lang racket

(provide set-filter
         set-length)

; Returns the set filtered by the predicate.
(define (set-filter pred? s)
  (for/set ((e s) #:when (pred? e)) e))

; Returns the length of the set.
(define (set-length s)
  (sequence-length s))
