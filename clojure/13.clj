(use '[clojure.string :only (split-lines)])

(def parse-number #(new BigDecimal %))

(println
  ((comp #(apply str %)
         #(take 10 %)
         str
         #(reduce + %)
         #(map parse-number %))
    (split-lines (slurp "../data/13.txt"))))
