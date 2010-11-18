(use '[clj-pelib.math :only (totient)])

; Very interesting output; the best candidates have digits like
; abcabc.  For example, 250250, 990990, and 510510 produce the
; best ratios.  Also, 510510 is the best answer.
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
