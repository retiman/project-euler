(require '[clojure.string :as s])

(def data
  (s/split (s/replace (slurp "../data/22.txt") #"\"" "") #","))

(def scores
  (zipmap (map char (range (int \A) (inc (int \Z))))
          (range 1 (inc 26))))

(defn score [x]
  (reduce + (map scores x)))

(def m
  (zipmap (range 1 (inc (count data)))
          (map score (sort data))))

(def result
  (reduce +
    (for [k (keys m)]
      (* k (m k)))))

(println result)
(assert (= result 871198282))
