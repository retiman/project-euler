(define (palindrome? n)
  (let ((s (number->string n)))
    (string=? s (list->string (reverse (string->list s))))))

(displayln
  (apply max
    (for*/list
      ((i (range 999 1 -1))
       (j (range i 1 -1))
       #:when (palindrome? (* i j)))
      (* i j))))
