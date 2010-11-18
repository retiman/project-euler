(use 'clj-pelib.math)

(def pairs
  (for [n (range 2 (inc 1000000))]
    (let [phi (totient n)
          ratio (/ n phi)]
      (do
        (println [n ratio])
        [n ratio]))))

(println
  (first
    (reduce (fn [a b] (if (> (last a) (last b)) a b))
            pairs)))
