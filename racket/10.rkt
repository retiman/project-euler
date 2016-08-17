; Problem #10: https://projecteuler.net/problem=10

(displayln
  (apply + (filter (curryr < 2000000) (file->list "../data/primes.txt"))))
