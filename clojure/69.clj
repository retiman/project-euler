; 510510
; 2.62user 0.23system 0:02.45elapsed 116%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+24outputs (0major+17425minor)pagefaults 0swaps

(use '[clojure.contrib.lazy-seqs :only (primes)])

(defn f [acc ps]
  (let [n (* acc (first ps))]
    (if (> n 1000000)
      acc
      (recur n (rest ps)))))

(println (f 1 primes))
