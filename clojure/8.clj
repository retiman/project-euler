; 40824
; 1.16user 0.06system 0:00.81elapsed 151%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+64outputs (1major+19958minor)pagefaults 0swaps

(use '[clojure.contrib.str-utils2 :only (split-lines)])

(def parse-int #(Integer/parseInt (str %)))

(def s (apply str (split-lines (slurp "../data/8.txt"))))

(println
  (apply max
    (for [i (range 1 (- (count s) 4))]
      (reduce * (map #(parse-int (get s %)) (range i (+ i 5)))))))
