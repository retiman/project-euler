(load-file "lib/core.clj")
(use '[lib.core :only (sigma)])

(defn sigma* [n]
  (- (sigma n) n))

(println
  (reduce +
    (for [a (range 2 (inc 10000))
          :let [b (sigma* a)]
          :when (and (> a b) (= (sigma* b) a))]
      (+ a b))))
