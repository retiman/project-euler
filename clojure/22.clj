(require '[clojure.string :as su])

(def data
  (su/split (su/replace (slurp "../data/22.txt") #"\"" "") #","))

(def scores
  (zipmap (map char (range (int \A) (inc (int \Z))))
          (range 1 (inc 26))))

(defn score [s]
  (reduce + (map scores s)))

(def m
  (zipmap (range 1 (inc (count data)))
          (map score (sort data))))

(println
  (reduce +
    (for [k (keys m)]
      (* k (m k)))))
