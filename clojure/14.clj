(defn collatz-length [n]
  (let [length (fn [n acc]
                 (cond
                   (= n 1) acc
                   (even? n) (recur (/ n 2) (inc acc))
                   (odd? n) (recur (+  1 (* 3 n)) (inc acc))))]
    (length n 0)))

(def memoized-collatz-length (memoize collatz-length))

(println
  (reduce max (map memoized-collatz-length (range 1 1000000))))
