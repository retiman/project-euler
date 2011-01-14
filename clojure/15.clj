; 137846528820
; 0.90user 0.02system 0:00.65elapsed 141%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+64outputs (1major+13952minor)pagefaults 0swaps

(defn fact [n] (reduce * (range 1 n)))

(let [n (fact (+ 20 20))
      d (* (fact 20) (fact 20))
      r (/ n d)]
  (println r))
