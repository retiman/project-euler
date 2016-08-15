(require "lib/core.rkt")
(require "lib/number-theory.rkt")

(define s
  (letrec ((f (λ (xs x d)
                (if (< d 1000000)
                  (f (cons x xs) (add1 x) (+ d (digits x)))
                  xs))))
    ((compose (curry apply string-append)
              (curry map number->string)
              reverse)
       (f '() 1 0))))

(define (product acc index)
  (if (< index 1000000)
    (product (* acc (char->integer* (string-ref s (sub1 index)))) (* index 10))
    acc))

(displayln
  (product 1 1))
