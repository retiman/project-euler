; 31875000
; 1.64user 0.09system 0:00.96elapsed 180%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+64outputs (1major+22320minor)pagefaults 0swaps

(println
  (first
    (for [a (range 1 333)
          b (range a (/ (- 1000 a) 2))
          :let [c (- 1000 a b)]
          :when (= (+ (* a a) (* b b))
                   (* c c))]
      (* a b c))))
