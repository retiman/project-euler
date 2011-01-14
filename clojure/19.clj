; 171
; 2.54user 0.22system 0:02.90elapsed 95%CPU (0avgtext+0avgdata 0maxresident)k
; 264inputs+24outputs (0major+14339minor)pagefaults 0swaps

(import [java.util Calendar])

(def cal (Calendar/getInstance))

(def sundays (atom 0))

(doseq [year (range 1901 2001)
        month (range 0 12)]
  (.set cal year month 1)
  (when (= (.get cal Calendar/DAY_OF_WEEK) Calendar/SUNDAY)
    (swap! sundays inc)))

(println @sundays)
