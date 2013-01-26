(define (palindrome? n)
  (let ((s (number->string n)))
    (string=? s (list->string (reverse (string->list s))))))

(display
  (foldl
    max
    0
    (for*/list
      ((i (stream->list (in-range 999 1 -1)))
       (j (stream->list (in-range i   1 -1)))
       #:when (palindrome? (* i j)))
      (* i j))))
(newline)
