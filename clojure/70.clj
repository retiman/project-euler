(use 'clj-pelib.math)

(defn permutation?
  "Returns true if a's digits are a permutation of b's digits; false
  otherwise."
  [a b]
  (let [digits #(sort (into [] (str %)))]
    (= (digits a) (digits b))))

(def pairs
  (for [p (range 2 10000000)
        :let [phi (dec p)]
        :when (and (prime? p)
                   (permutation? p phi))]
    (let [pair [p (/ p phi)]]
      (do
        (println pair)
        pair))))

(println
  "And the winner is..."
  (reduce (fn [a b] (if (< (last a) (last b)) a b))
          pairs))
