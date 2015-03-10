(displayln
  (apply + (filter (λ (n) (or (zero? (modulo n 3))
                              (zero? (modulo n 5))))
                   (range 1000))))
