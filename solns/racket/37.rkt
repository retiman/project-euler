#lang racket
(require rackunit)
(require "lib/core.rkt")
(require "lib/string.rkt")
(require "lib/number-theory.rkt")

(define primes
  (filter (curryr < 1000000) (file->list "/data/primes.txt")))

(define limit 11)

(define (truncate* n direction)
  (let* ((s (number->string n))
         (k (if (symbol=? direction 'left)
              (string-drop 1 s)
              (string-take (sub1 (string-length s)) s))))
    (string->number k)))

(define truncatable?
  (case-lambda
    ((n) (and (truncatable? n 'left) (truncatable? n 'right)))
    ((n direction) (and (prime? n)
                        (or (< n 10)
                            (truncatable? (truncate* n direction)
                                          direction))))))

(define find-primes
  (case-lambda
    ((ps) (find-primes ps '()))
    ((ps ts) (let ((p (car ps)))
               (cond ((< p limit) (find-primes (cdr ps) ts))
                     ((= (length ts) limit) ts)
                     (else (if (truncatable? p)
                             (find-primes (cdr ps) (cons p ts))
                             (find-primes (cdr ps) ts))))))))

(define result
  (for/sum ((p (find-primes primes))) p))

(displayln result)
(check-equal? result 748317)
