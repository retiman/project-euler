; 648
; 5.37user 0.44system 0:05.52elapsed 105%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+24outputs (0major+20407minor)pagefaults 0swaps

(load-file "lib/core.clj")
(use '[lib.core :only (fact parse-int)])

(println
  (reduce + (map (comp parse-int str) (str (fact 100)))))
