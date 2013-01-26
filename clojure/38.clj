(load-file "lib/core.clj")
(use 'clojure.math.combinatorics)

(def pandigitals
  (set (map #(apply str %) (permutations (range 1 10)))))

(defn pandigital?
  "Returns true if s is a 1 to 9 pandigital; false otherwise."
  [s]
  (contains? pandigitals s))

(defn pandigital-product
  "Creates a 1 to 9 pandigital from consecutive digits starting from 2.
  The problem does not make it especially clear that the pandigital
  product must have exactly 9 digits and 'trivial' products like
  1 * 987654321 are not permitted."
  [n]
  (loop [s "" i 1]
    (cond
      (= (count s) 9) (if (= i 1) nil s)
      (> (count s) 9) nil
      :default (recur (str s (* n i)) (inc i)))))

(println
  (reduce max
    (for [x (range 1 99999)
          :let [p (pandigital-product x)]
          :when (pandigital? p)]
      (Integer/parseInt p))))
