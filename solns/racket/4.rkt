#!/usr/bin/env racket
#lang racket
(require rackunit)


(define (palindrome? n)
  (let ((s (number->string n)))
    (string=? s (list->string (reverse (string->list s))))))

; Search from 1000 backwards because we are looking for the largest palindrome.
; It's not necessary to search values of j between 1-999; for example, if
; i = 998, it's not needed to check j = 999 as the (999, 998) pair was checked
; when i = 999.
(define result
  (apply max
    (for*/list ((i (range 999 1 -1))
                (j (range i 1 -1))
                #:when (palindrome? (* i j)))
      (* i j))))

(displayln result)
(check-equal? result 906609)
