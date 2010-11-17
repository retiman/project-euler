(use 'clojure.set)
(use 'clojure.contrib.math)

(defn isqrt
  "Returns the integer square root of n."
  [n]
  (first (exact-integer-sqrt n)))

(defn divisors
  "Returns the set of divisors of n, including 1 and n itself.  This uses a
  naive algorithm, but memoizes the result."
  [n]
  (let [xs (filter #(zero? (mod n %)) (range 2 (inc (isqrt n))))
        ys (map #(quot n %) xs)]
    (union #{1} #{n} (set xs) (set ys))))

(defn prime?
  "Returns true if n is prime; false otherwise."
  [n]
  (or (= n 2)
      (= (count (divisors n)) 2)))

(defn prime-factors
  "Returns the prime factors of n."
  [n]
  (filter prime? (divisors n)))

(defn totient
  "Returns the totient of n; the number of positive integers less than or
  equal to n that are relatively prime to n."
  [n]
  (cond
    (= n 1) 0
    :default (reduce (fn [a b] (* (/ a b) (dec b)))
                     n
                     (prime-factors n))))

(defn permutation?
  "Returns true if a's digits are a permutation of b's digits; false
  otherwise."
  [a b]
  (let [digits #(sort (into [] (str %)))]
    (= (digits a) (digits b))))


(def divisors (memoize divisors))

(def prime-factors (memoize prime-factors))

(def totient (memoize totient))

(def pairs
  (for [n (range 2 10000000)
        :let [phi (totient n)]
        :when (permutation? n phi)]
    [n (/ n phi)]))

(reduce (fn [a b] (let [x (last a) y (last b)] (if (< x y) x y))) pairs)
