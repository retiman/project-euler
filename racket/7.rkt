; 104743
; 16.43user 1.12system 0:17.57elapsed 99%CPU (0avgtext+0avgdata 424440maxresident)k
; 0inputs+0outputs (0major+81966minor)pagefaults 0swaps

(display
  (first (drop (file->list "../data/primes.txt") 10000)))
(newline)
