; JAVA_OPTS="-Xmx1024M" time clojure 1.clj
; 233168
; 0.92user 0.05system 0:00.64elapsed 151%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+64outputs (1major+13859minor)pagefaults 0swaps

(println
  (apply +
    (filter
      (fn [x]
        (or (= 0 (rem x 3))
            (= 0 (rem x 5))))
      (range 1 1000))))
