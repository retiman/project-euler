(displayln
  (apply + (filter (lambda (n)
                     (or (zero? (modulo n 3))
                         (zero? (modulo n 5))))
                   (range 1000))))
