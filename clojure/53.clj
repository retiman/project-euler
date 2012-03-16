; 4075
; 7.42user 0.36system 0:05.56elapsed 140%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+0outputs (0major+27329minor)pagefaults 0swaps

(load-file "lib/core.clj")
(use
  '[clj-euler.core :only (choose)])

(println
  (count
    (for [n (range 1 (inc 100))
          r (range 1 (dec n))
          :let [c (choose n r)]
          :when (> c 1000000)]
        c)))
