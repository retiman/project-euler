; 40824
; 0.27user 0.05system 0:00.33elapsed 99%CPU (0avgtext+0avgdata 39020maxresident)k
; 0inputs+0outputs (0major+12481minor)pagefaults 0swaps

(define (char->number c)
  (string->number (make-string 1 c)))

(define data
  (foldl string-append "" (file->lines "../data/8.txt")))

(display
  (apply
    max
    (for/list
      ([i (stream->list (in-range 1 (- (string-length data) 4)))])
       (foldl * 1 (map (lambda (j) (char->number (string-ref data j)))
                       (stream->list (in-range i (+ i 5))))))))
(newline)
