; JAVA_OPTS="-Xmx1024M" time clojure 7.clj
; 104729
; 225.65user 1.84system 3:32.83elapsed 106%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+248outputs (1major+190451minor)pagefaults 0swaps

(use '[clojure.contrib.math :only (sqrt)])

(defn is-prime? [ps n]
  #^{:doc "Checks ps to determine whether or not n is prime"}
  (empty? (filter #(and (<= % (sqrt n)) (= (rem n %) 0)) ps)))

(defn next-prime [ps]
  #^{:doc "Returns a next prime in the sequence"}
  (first
      (drop-while #(not (is-prime? ps %))
                  (iterate #(+ % 2) (+ (first ps) 2)))))

(println
  (loop [n 3 ps '(3 2)]
    (if (= n 10001) (first ps)
      (recur (inc n) (cons (next-prime ps) ps)))))
