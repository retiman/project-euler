(def fibs (lazy-cat '(0 1) (map + fibs (rest fibs))))
(def result (reduce + (filter even? (take-while #(< % 4000000) fibs))))

(println result)
(assert (= result 4613732))
