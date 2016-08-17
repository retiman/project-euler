; Problem #14: https://projecteuler.net/problem=14

(require "lib/core.rkt")

(define-memo (collatz-length n)
  (define (loop i acc)
    (cond ((= i 1) acc)
          ((even? i) (loop (/ i 2) (add1 acc)))
          ((odd? i) (loop (+ 1 (* 3 i)) (add1 acc)))))
  (loop n 0))

(define (number->pair n)
  (cons (collatz-length n) n))

(displayln
  (let* ((n 1000000)
         (h (apply make-hash (list (map number->pair (range 1 n)))))
         (k (apply max (hash-keys h))))
    (hash-ref h k)))
