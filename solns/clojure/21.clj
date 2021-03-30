(load-file "lib/number-theory.clj")
(use '[lib.number-theory :only (sigma*)])

(def result
  (reduce +
    (for [a (range 2 (inc 10000))
          :let [b (sigma* a)]
          :when (and (> a b) (= (sigma* b) a))]
      (+ a b))))

(println result)
(assert (= result 31626))
