; 31626
; 8.27user 0.37system 0:07.63elapsed 113%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+24outputs (0major+30721minor)pagefaults 0swaps

(use 'clj-pelib.math)

(defn sigma* [n]
  (- (sigma n) n))

(println
  (reduce +
    (for [a (range 2 (inc 10000))
          :let [b (sigma* a)]
          :when (and (> a b) (= (sigma* b) a))]
      (+ a b))))
