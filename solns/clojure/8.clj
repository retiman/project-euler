(load-file "lib/core.clj")
(require
  '[clojure.string :refer [split-lines]]
  '[lib.core :refer [parse-int]])


(def s (apply str (split-lines (slurp "../data/8.txt"))))
(def result
  (apply max
    (for [i (range 1 (- (count s) 4))]
      (reduce * (map #(parse-int (get s %)) (range i (+ i 5)))))))

(println result)
(assert (= result 40824))
