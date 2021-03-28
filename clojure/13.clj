(load-file "lib/core.clj")
(use
  '[clojure.string :only (split-lines)]
  '[lib.core :only (parse-long)])


(def parse-number #(new BigDecimal %))

(def result
  ((comp parse-long
         #(apply str %)
         #(take 10 %)
         str
         #(reduce + %)
         #(map parse-number %))
    (split-lines (slurp "../data/13.txt"))))

(println result)
(assert (= result 5537376230))
