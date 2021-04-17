#lang racket
(require rackunit)
(require "lib/core.rkt")

(define pandigitals
  (list->set (map list->integer (permutations (range 1 10)))))

(define (pandigital? n)
  (set-member? pandigitals n))

(define (string-append* s n)
  (string-append s (number->string n)))

; Creates a 1 to 9 pandigital from consecutive digits starting from 2.
; The problem does not make it especially clear that the pandigital
; product must have exactly 9 digits and 'trivial' products like
; 1 * 987654321 are not permitted."
(define pandigital-product
  (case-lambda
    ((n) (pandigital-product n "" 1))
    ((n s i) (cond
               ((= (string-length s) 9) (if (= i 1) "" s))
               ((> (string-length s) 9) "")
               (else (pandigital-product n (string-append* s (* n i)) (add1 i)))))))

(define result
  (let* ((xs (range 1 99999))
         (ys (map (compose string->number pandigital-product) xs))
         (zs (filter pandigital? ys)))
    (apply max zs)))

(displayln result)
(check-equal? result 932718654)
