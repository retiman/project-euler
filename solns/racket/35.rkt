#lang racket
(require rackunit)
(require "lib/core.rkt")
(require "lib/number-theory.rkt")


(define primes
  (filter (curryr < 1000000) (file->list "../data/primes.txt")))

(define (rotate lst)
  (append (cdr lst) (list (car lst))))

(define (rotations n)
  (define (loop lst acc)
    (let ((lst* (rotate lst))
          (acc* (if (empty? acc) (list lst) acc)))
      (if (= (length lst*) (length acc*))
        acc*
        (loop lst* (append acc* (list lst*))))))
  (map list->integer (loop (integer->list n) empty)))

(define (circular? p)
  (andmap prime? (rotations p)))

(define result (length (filter circular? primes)))

(displayln result)
(check-equal? result 55)
