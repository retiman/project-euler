; 906609
; 0.83user 0.04system 0:00.88elapsed 99%CPU (0avgtext+0avgdata 60060maxresident)k
; 0inputs+0outputs (0major+13686minor)pagefaults 0swaps

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
