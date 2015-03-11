#lang racket

(provide char->number
         set-length
         stream-take
         stream-takef)

(define (char->number c)
  (string->number (make-string 1 c)))

(define (set-length s)
  (sequence-length s))

(define (stream-take s n)
  (for/list ((e s) (i (in-range n))) e))

(define (stream-takef s f)
  (for/list ((e s) #:break (not (f e))) e))

(define (memoize f)
  (local ((define table (make-hash)))
    (λ args (dict-ref! table args (λ () (apply f args))))))
