#lang racket

(provide stream-take
         stream-takef)

(define (stream-take s n)
  (for/list ((e s) (i (in-range n))) e))

(define (stream-takef s f)
  (for/list ((e s) #:break (not (f e))) e))
