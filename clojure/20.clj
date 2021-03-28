(load-file "lib/core.clj")
(load-file "lib/number-theory.clj")
(use
  '[lib.core :only (parse-int)]
  '[lib.number-theory :only (fact)])

(def result
  (reduce + (map (comp parse-int str) (str (fact 100)))))

(println result)
(assert (= result 648))
