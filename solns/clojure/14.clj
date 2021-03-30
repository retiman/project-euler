(defn collatz-length* [n]
  (letfn [(length [n acc]
            (cond
              (= n 1) acc
              (even? n) (recur (/ n 2) (inc acc))
              (odd? n) (recur (+  1 (* 3 n)) (inc acc))))]
    (length n 0)))

(def collatz-length (memoize collatz-length*))

(def result
  (let [n 1000000
        h (apply merge (map #(hash-map (collatz-length %) %) (range 1 n)))
        m (apply max (keys h))
        r (h m)]
    r))

(println result)
(assert (= result 837799))
