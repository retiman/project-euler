; 5537376230
; 4.75user 0.37system 0:05.10elapsed 100%CPU (0avgtext+0avgdata 0maxresident)k
; 32inputs+16outputs (0major+21588minor)pagefaults 0swaps

(use '[clojure.string :only (split-lines)])

(def parse-number #(new BigDecimal %))

(println
  ((comp #(apply str %)
         #(take 10 %)
         str
         #(reduce + %)
         #(map parse-number %))
    (split-lines (slurp "../data/13.txt"))))
