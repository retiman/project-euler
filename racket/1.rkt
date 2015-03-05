(displayln
  (apply + (filter (lambda (n)
                     (or (zero? (modulo n 3))
                         (zero? (modulo n 5))))
                   (build-list 1000 values))))
