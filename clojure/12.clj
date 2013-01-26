(load-file "lib/core.clj")
(use '[lib.core :only (tau)])
(use '[clojure.math.numeric-tower :only (sqrt)])

(println
  (loop [n 3 i 3]
    (if (> (tau n) 500)
      n
      (recur (+ n i) (inc i)))))
