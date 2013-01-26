(load-file "lib/core.clj")
(use '[lib.core :only (fact parse-int)])

(println
  (reduce + (map (comp parse-int str) (str (fact 100)))))
