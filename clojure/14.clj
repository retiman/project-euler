; JAVA_OPTS="-Xmx1024M" time clojure 14.clj
; 837799
; 35.67user 0.95system 0:23.78elapsed 153%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+64outputs (1major+306196minor)pagefaults 0swaps

(defn collatz-length* [n]
  (let [length (fn [n acc]
                 (cond
                   (= n 1) acc
                   (even? n) (recur (/ n 2) (inc acc))
                   (odd? n) (recur (+  1 (* 3 n)) (inc acc))))]
    (length n 0)))

(def collatz-length (memoize collatz-length*))

(let [n 1000000
      h (apply merge (map #(hash-map (collatz-length %) %) (range 1 n)))
      m (apply max (keys h))
      r (h m)]
  (println r))
