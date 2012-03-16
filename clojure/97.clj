; 8739992577
; 8.81user 0.37system 0:08.70elapsed 105%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+16outputs (0major+25013minor)pagefaults 0swaps

(load-file "lib/core.clj")
(use
  '[clojure.math.numeric-tower]
  '[clj-euler.core :only (mod-pow)])

(def m (expt 10 10))

(println
  (mod (inc (* 28433 (mod-pow 2 7830457 m))) m))
