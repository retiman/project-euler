(use '[cemerick.pomegranate :only (add-dependencies)])
(add-dependencies :coordinates '[[org.clojure/math.numeric-tower "0.0.1"]])
(use '[clojure.math.numeric-tower :only (expt)])

(println (reduce + (map #(Integer/parseInt (str %)) (str (expt 2 1000)))))
