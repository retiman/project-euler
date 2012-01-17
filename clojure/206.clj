; 1389019170
; 8.30user 0.42system 0:07.92elapsed 110%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+16outputs (0major+21759minor)pagefaults 0swaps

(load-file "lib/core.clj")

(println
  (loop [n (inc (isqrt 19293949596979899))]
    (let [k (* n n)]
      (if (re-matches #"1\d2\d3\d4\d5\d6\d7\d8\d9" (str k))
        (* n 10)
        (recur (- n 2))))))
