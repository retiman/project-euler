(load-file "lib/number-theory.clj")
(require
  '[lib.number-theory :refer [choose]])


(def result
  (count
    (for [n (range 1 (inc 100))
          r (range 1 (dec n))
          :let [c (choose n r)]
          :when (> c 1000000)]
        c)))

(println result)
(assert (= result 4075))
