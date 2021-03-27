(def result
  (reduce +
    (filter #(or (zero? (rem % 3))
                 (zero? (rem % 5)))
            (range 1000))))

(println result)
(assert (= result 233168))
