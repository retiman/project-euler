(define x
  (letrec ((f (lambda (s i)
                (if (< (string-length s) 1000000)
                  (f (string-append s (number->string i)) (add1 i))
                  s))))
    (f "" 1)))

(define (product acc index)
  (if (< index 1000000)
    (product (* acc (char->integer* (string-ref x (sub1 index)))) (* index 10))
    acc))

(displayln
  (product 1 1))
