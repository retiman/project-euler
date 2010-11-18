(use 'clojure.contrib.combinatorics)

(defn digits [n]
  (into #{} (map #(first (str %)) (range 1 (inc n)))))

(defn pandigital? [n]
  (let [xs (into #{} n)
        ys (digits (count n))]
    (= xs ys)))

(defn concatenated-product [n]
  (let [cs (map #(* n %) (range 1 10))
        ts (take 9 (apply str cs))]
    (apply str ts)))

(def digits (memoize digits))

(comment
(def pandigitals
  (for [n (range 1 987654321)
        :let [p (concatenated-product n)]
        :when (pandigital? p)]
    (Long/parseLong p)))

(println
  (apply max pandigitals)))




(def pandigitals
  (set (permutations (map #(first (str %)) (range 1 3)))))

(defn pandigital? [n]
  (contains pandigitals n))

(defn concatenated-product [n]
  (Integer/parseInt
    (apply str
      (take 9
        (apply str
          (map #(* n %) (range 1 10)))))))
