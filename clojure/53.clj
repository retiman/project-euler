(use '[clj-pelib.math :only (choose)])

(def choices
  (for [n (range 1 (inc 100))
        r (range 1 (dec n))
        :let [c (choose n r)]
        :when (> c 1000000)]
      c))

(println (count choices))
