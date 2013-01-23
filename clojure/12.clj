; 76576500
; 15.98user 0.44system 0:13.62elapsed 120%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+0outputs (0major+62317minor)pagefaults 0swaps

(load-file "lib/core.clj")
(use '[lib.core :only (tau)])
(use '[clojure.math.numeric-tower :only (sqrt)])

(println
  (loop [n 3 i 3]
    (if (> (tau n) 500)
      n
      (recur (+ n i) (inc i)))))
