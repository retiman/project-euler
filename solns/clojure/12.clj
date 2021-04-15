(load-file "lib/number-theory.clj")
(require
  '[lib.number-theory :refer [tau]])


(def result
  (loop [n 3 i 3]
    (if (> (tau n) 500)
      n
      (recur (+ n i) (inc i)))))

(println result)
(assert (= result 76576500))
