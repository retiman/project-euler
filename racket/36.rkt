(define (palindrome? x)
  (if (string? x)
    (let ((lst (string->list x)))
      (equal? lst (reverse lst)))
    (and (palindrome? (number->string x 2))
         (palindrome? (number->string x 10)))))

(displayln
  (for/sum ((n (in-range 1000000))
            #:when (palindrome? n))
    n))
