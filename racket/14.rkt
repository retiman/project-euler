(require "lib/core.rkt")

(define/memo (collatz-length n)
  (define (collatz-length* i acc)
    (cond ((= i 1) acc)
          ((even? i) (collatz-length* (/ i 2) (add1 acc)))
          ((odd? i) (collatz-length* (+ 1 (* 3 i)) (add1 acc)))))
  (collatz-length* n 0))

(define (number->pair n)
  (cons (collatz-length n) n))

(displayln
  (let* ((n 1000000)
         (h (apply make-hash (list (map number->pair (range 1 n)))))
         (k (apply max (hash-keys h))))
    (hash-ref h k)))
