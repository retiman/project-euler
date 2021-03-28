#! /usr/bin/env racket
#lang racket
(require rackunit)
(require "lib/core.rkt")


(define (denominators n)
  (define (denominators* digit start)
    (flatten
      (for/list ((i (in-range start 10)))
        (list (list->integer (list i digit))
              (list->integer (list digit i))))))
  (let* ((lst (integer->list n))
         (a (car lst))
         (b (cadr lst)))
    (filter (curryr > n)
            (distinct (append (denominators* a a) (denominators* b a))))))

(define (cancellable? m n)
  (let* ((m* (integer->list m))
         (n* (integer->list n))
         (v (/ m n))
         (a (car m*))
         (b (cadr m*))
         (c (car n*))
         (d (cadr n*)))
    (cond ((ormap zero? (list a b c d)) #f)
          ((= a c) (= v (/ b d)))
          ((= a d) (= v (/ b c)))
          ((= b c) (= v (/ a d)))
          ((= b d) (= v (/ a c)))
          (else #f))))

(define result
  (denominator
    (for*/product ((m (range 11 99))
                   (n (denominators m))
                   #:when (cancellable? m n))
      (/ m n))))

(displayln result)
(check-equal? result 100)
