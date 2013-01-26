(display
  (foldl +
         0
         (filter (lambda (n)
                   (or (zero? (modulo n 3))
                       (zero? (modulo n 5))))
           (stream->list (in-range 1000)))))
(newline)
