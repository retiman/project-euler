(display
  (foldl
    +
    0
    (filter
      (lambda (p) (< p 2000000))
      (file->list "../data/primes.txt"))))
(newline)
