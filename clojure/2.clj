; 4613732
; 0.97user 0.04system 0:00.65elapsed 156%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+64outputs (1major+13834minor)pagefaults 0swaps

(def fibs (lazy-cat '(0 1) (map + fibs (rest fibs))))
(println (reduce + (filter even? (take-while #(< % 4000000) fibs))))
