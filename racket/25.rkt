(require "lib/core.rkt")

(define fibs
  (letrec ((f (λ (a b) (stream-cons a (f b (+ a b))))))
    (f 0 1)))

(define (number-length n)
  (string-length (number->string n)))

(displayln
  (for/last ((i (in-naturals))
             (n fibs)
             #:break (>= (number-length n) 1000))
    (add1 i)))
