; JAVA_OPTS="-Xmx1024M" time clojure 16.clj
; 1366
; 1.32user 0.10system 0:01.45elapsed 99%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+0outputs (0major+10090minor)pagefaults 0swaps

(use '[clojure.contrib.math :only (expt)])

(println (reduce + (map #(Integer/parseInt (str %)) (str (expt 2 1000)))))
