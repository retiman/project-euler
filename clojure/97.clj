(use '[clj-pelib.math])
(use '[clojure.contrib.math])

(def m (expt 10 10))

(println
  (mod (inc (* 28433 (mod-pow 2 7830457 m))) m))
