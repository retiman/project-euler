(load-file "lib/core.clj")
(load-file "lib/number-theory.clj")
(use
  '[lib.core :only (sqrt)]
  '[lib.number-theory :only (tau)])


(def result
  (loop [n 3 i 3]
    (if (> (tau n) 500)
      n
      (recur (+ n i) (inc i)))))

(println result)
(assert (= result 76576500))
