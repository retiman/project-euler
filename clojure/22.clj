; 871198282
; 7.04user 0.45system 0:09.31elapsed 80%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+24outputs (0major+23890minor)pagefaults 0swaps

(require '[clojure.contrib.str-utils2 :as su])

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
