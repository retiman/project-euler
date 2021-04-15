(load-file "lib/core.clj")
(load-file "lib/number-theory.clj")
(require
  '[lib.core :refer [parse-int]]
  '[lib.number-theory :refer [fact]])


(def result
  (reduce + (map (comp parse-int str) (str (fact 100)))))

(println result)
(assert (= result 648))
