; 104743
; 3.34user 0.11system 0:01.65elapsed 208%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+64outputs (1major+41156minor)pagefaults 0swaps

(use '[clojure.contrib.lazy-seqs :only (primes)])
(println (last (take 10001 primes)))
