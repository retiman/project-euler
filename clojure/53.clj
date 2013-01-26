(load-file "lib/core.clj")
(use '[lib.core :only (choose)])

(println
  (count
    (for [n (range 1 (inc 100))
          r (range 1 (dec n))
          :let [c (choose n r)]
          :when (> c 1000000)]
        c)))
