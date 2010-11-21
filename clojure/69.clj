; 510510

(use '[clj-pelib.math :only (totient)])

; This solution takes hours to run.  It can stand to be optimized.
(println
  (first
    (reduce (fn [a b]
              (if (> (last a) (last b))
                (do
                  (println a)
                  a)
                b))
            (map (fn [n] [n (/ n (totient n))])
                 (range 2 (inc 1000000))))))
