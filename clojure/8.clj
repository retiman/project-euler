(use '[clojure.string :only (split-lines)])

(def parse-int #(Integer/parseInt (str %)))

(def s (apply str (split-lines (slurp "../data/8.txt"))))

(println
  (apply max
    (for [i (range 1 (- (count s) 4))]
      (reduce * (map #(parse-int (get s %)) (range i (+ i 5)))))))
