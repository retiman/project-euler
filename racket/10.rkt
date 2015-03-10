(displayln
  (apply + (filter (λ (p) (< p 2000000)) (file->list "../data/primes.txt"))))
