; 25164150
; 0.98user 0.04system 0:00.65elapsed 154%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+64outputs (1major+13946minor)pagefaults 0swaps

(let [a (reduce + (map #(* % %) (range 1 101)))
      b (reduce + (range 1 101))
      r (- (* b b) a)]
  (println r))
