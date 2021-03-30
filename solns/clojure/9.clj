(def result
  (first
    (for [a (range 1 333)
          b (range a (/ (- 1000 a) 2))
          :let [c (- 1000 a b)]
          :when (= (+ (* a a) (* b b))
                   (* c c))]
      (* a b c))))

(println result)
(assert (= result 31875000))
