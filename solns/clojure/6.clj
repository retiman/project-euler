(def result
  (let [a (reduce + (map #(* % %) (range 1 101)))
        b (reduce + (range 1 101))
        r (- (* b b) a)]
    r))

(println result)
(assert (= result 25164150))
