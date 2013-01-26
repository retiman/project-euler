(def fibs (lazy-cat '(0 1) (map + fibs (rest fibs))))
(println (reduce + (filter even? (take-while #(< % 4000000) fibs))))
