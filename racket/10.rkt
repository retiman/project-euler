(displayln
  (apply + (filter (curryr < 2000000) (file->list "../data/primes.txt"))))
