#lang racket
(require rackunit)


(define (palindrome? x)
  (if (string? x)
    (let ((lst (string->list x)))
      (equal? lst (reverse lst)))
    (and (palindrome? (number->string x 2))
         (palindrome? (number->string x 10)))))

(define result
  (for/sum ((n (in-range 1000000))
            #:when (palindrome? n))
    n))

(displayln result)
(check-equal? result 872187)
