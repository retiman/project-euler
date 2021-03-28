#! /usr/bin/env racket
#lang racket
(require rackunit)
(require "lib/number-theory.rkt")


(define numbers
  (filter (lambda (n) (and (not (divides? 2 n)) (not (divides? 5 n))))
          (range 999 1 -1)))

(define (max-period best numbers)
  (if (empty? numbers)
    best
    (let* ((n (first numbers))
           (t (ord 10 n)))
      (cond ((= t (sub1 n)) (cons n t))
            ((> t (cdr best)) (max-period (cons n t) (rest numbers)))
            (else (max-period best (rest numbers)))))))

(define result (car (max-period (cons 0 0) numbers)))

(displayln result)
(check-equal? result 983)
