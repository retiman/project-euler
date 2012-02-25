; 142913828922
; 16.50user 1.34system 0:17.93elapsed 99%CPU (0avgtext+0avgdata 415548maxresident)k
; 0inputs+0outputs (0major+160754minor)pagefaults 0swaps

(display
  (foldl
    +
    0
    (filter
      (lambda (p) (< p 2000000))
      (file->list "../data/primes.txt"))))
(newline)
