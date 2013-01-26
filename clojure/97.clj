(load-file "lib/core.clj")
(use
  '[clojure.math.numeric-tower]
  '[lib.core :only (mod-pow)])

(def m (expt 10 10))

(println
  (mod (inc (* 28433 (mod-pow 2 7830457 m))) m))
