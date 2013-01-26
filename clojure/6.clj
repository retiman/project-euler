(let [a (reduce + (map #(* % %) (range 1 101)))
      b (reduce + (range 1 101))
      r (- (* b b) a)]
  (println r))
