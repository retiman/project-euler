(load-file "lib/core.clj")
(use '[clojure.set :only (union)])
(use '[clojure.math.numeric-tower :only (ceil sqrt round)])

(defn fermat-factors
  "Uses Fermat's factorization method to return 2 factors of n, if possible."
  [n]
  (if (= 0 (rem n 2))
    (sorted-set n (/ n 2))
    (loop [a (ceil (sqrt n))]
      (let [b (- (* a a) n)
            s (sqrt b)]
        (if (== s (round s))
          (sorted-set (- a s) (+ a s))
          (recur (inc a)))))))

(defn prime-factors
  "Returns the prime factors of n, using Fermat's factorization method."
  [n]
  (let [factors (fermat-factors n)]
    (if (contains? factors 1.0)
      (disj factors 1.0)
      (reduce union (map prime-factors factors)))))

(println (reduce max (prime-factors 600851475143)))
