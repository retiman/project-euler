#! /usr/bin/env racket
#lang racket
(require rackunit)
(require (for-syntax racket/function))
(require (for-syntax racket/syntax))


(begin-for-syntax
  (define (make-id stx id-fragment)
    ((compose (curry datum->syntax stx)
              string->symbol
              (curry format "p~a")
              syntax->datum) id-fragment)))

(define-syntax (define-p stx)
  (syntax-case stx ()
    ((_ x y)
     (with-syntax ((px (make-id stx #'x))
                   (py (make-id stx #'y)))
                   #'(define (px n)
                       (if (>= n 0)
                         (+ (px (- n x)) (py n))
                         0))))))

(define (p1 n) 1)

(define-p 2 1)

(define-p 5 2)

(define-p 10 5)

(define-p 20 10)

(define-p 50 20)

(define-p 100 50)

(define-p 200 100)

(define result (p200 200))

(displayln result)
(check-equal? result 73682)
