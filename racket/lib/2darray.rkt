#lang racket

(provide make-2darray
         2darray-in-bounds?
         2darray-num-cols
         2darray-num-rows
         2darray-ref
         2darray-row-ref
         2darray-set!)

(define (make-2darray m n)
  (for/vector ((k (in-range m)))
    (make-vector n)))

(define (2darray-in-bounds? a i j)
  (and (>= i 0)
      (< i (2darray-num-rows a))
      (>= j 0)
      (< j (2darray-num-cols a))))

(define (2darray-num-cols a)
  (vector-length (2darray-row-ref a 0)))

(define (2darray-num-rows a)
  (vector-length a))

(define (2darray-ref a i j)
  (vector-ref (vector-ref a i) j))

(define (2darray-row-ref a i)
  (vector-ref a i))

(define (2darray-set! a i j x)
  (vector-set! (2darray-row-ref a i) j x))
