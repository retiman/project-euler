(load-file "lib/core.clj")
(use
  '[clojure.set :only (union)]
  '[lib.core :only (ceil round sqrt)])


(defn fermat-factors
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
  [n]
  (let [factors (fermat-factors n)]
    (if (contains? factors 1.0)
      (disj factors 1.0)
      (reduce union (map prime-factors factors)))))

(def result (long (reduce max (prime-factors 600851475143))))

(println result)
(assert (= result 6857))
