; JAVA_OPTS="-Xmx1024M" time clojure 13.clj
; 5537376230
; 1.56user 0.14system 0:01.77elapsed 96%CPU (0avgtext+0avgdata 0maxresident)k
; 64inputs+0outputs (0major+10217minor)pagefaults 0swaps

(use '[clojure.contrib.str-utils2 :only (split-lines)])

(def parse-number #(BigDecimal. %))

(println
  (apply str
    (take 10
      (str
        (reduce +
          (map parse-number
            (split-lines (slurp "../data/13.txt"))))))))
