(define (char->number c)
  (string->number (make-string 1 c)))

(define data
  (foldl string-append "" (file->lines "../data/8.txt")))

(display
  (apply
    max
    (for/list
      ((i (stream->list (in-range 1 (- (string-length data) 4)))))
      (foldl * 1 (map (lambda (j) (char->number (string-ref data j)))
                      (stream->list (in-range i (+ i 5))))))))
(newline)
