(require
  '[clojure.string :as s]
  '[clojure.contrib.generic.math-functions :as gmath]
  '[clojure.contrib.math :as math])
(use
  '[clojure.set :only (union)]
  '[clojure.contrib.math :only (abs gcd)])

(def ln gmath/log)

(defn parse-int
  "Parse an Integer from a String."
  [n]
  (Integer/parseInt n))

(defn parse-long
  "Parse a Long from a String."
  [n]
  (Long/parseLong n))

(defn load-primes
  "Returns a seq of primes loaded from a file."
  [file]
  (map parse-long (s/split-lines (slurp file))))

(defn log
  "Returns the log base b of n."
  [b n]
  (/ (ln n) (ln b)))

(defn lg
  "Returns the log base 2 of n."
  [n]
  (log 2 n))

(defn permute
  "Returns the number of permutations of r distinct elements from a set of n
  elements."
  [n r]
  (if (zero? r) 1 (reduce * (range n (- n r) -1))))

(defn fact
  "Returns the factorial of n."
  [n]
  (permute n n))

(defn choose
  "Returns the number of combinations of k elements from a set of n elements."
  [n r]
  (if (< n r) 0 (quot (permute n r) (fact r))))

(defn digital-root
  "Returns the digital root of n."
  [n]
  (- n (* (quot n 9) 9)))

(defn isqrt
  "Returns the integer square root of n."
  [n]
  (first (math/exact-integer-sqrt n)))

(defn mod-pow
  "Returns the remainder of b raised to the e-th power when divided by m."
  [b e m]
  (let [f (fn [a b e]
            (if (<= e 0)
              a
              (let [t (if (= (bit-and e 1) 1) (mod (* a b) m) a)]
                (recur t (mod (* b b) m) (bit-shift-right e 1)))))]
    (f 1 b e)))

(defn divisors-
  "Returns the set of divisors of n, including 1 and n itself.  This uses a
  naive algorithm, but memoizes the result."
  [n]
  (let [xs (filter #(zero? (mod n %)) (range 2 (inc (isqrt n))))
        ys (map #(quot n %) xs)]
    (union #{1} #{n} (set xs) (set ys))))

(def
  ^{:doc "Memoized version of divisors-."}
  divisors (memoize divisors-))

(defn tau
  "Returns the number of divisors of n."
  [n]
  (count (divisors n)))

(defn sigma
  "Returns the sum of divisors of n."
  [n]
  (reduce + (divisors n)))

(defn probable-prime?
  "Returns true if n is probably prime."
  ([n] (probable-prime? n 10))
  ([n certainty] (. (bigint n) isProbablePrime certainty)))

(defn prime?
  "Returns true if n is prime; false otherwise."
  [n]
  (or (= n 2)
      (= (count (divisors n)) 2)))

(defn prime-factors
  "Returns the prime factors of n."
  [n]
  (filter prime? (divisors n)))

(defn totient-
  "Returns the totient of n; the number of positive integers less than or
  equal to n that are relatively prime to n."
  [n]
  (cond
    (= n 1) 0
    :default (reduce (fn [a b] (* (/ a b) (dec b)))
                     n
                     (prime-factors n))))

(def
  ^{:doc "Memoized version of totient-."}
  totient (memoize totient-))

(defn order-
  "Returns the order of a modulo m.  The order is the smallest positive
  integer k such that a to the k-th power is congruent to 1 modulo m.
  Note that the order does not exist if a and m are not relatively prime."
  [a m]
  (if (not= (gcd a m) 1)
    (throw (new IllegalArgumentException (str [a m])))
    (let [phi (totient m)
          ds (divisors phi)]
      (first (drop-while #(> (mod-pow a % m) 1) ds)))))

(def
  ^{:doc "Memoized version of order-."}
  order (memoize order-))

(defn mod-tet
  "Returns the remainder of b exponentiated by itself, e times, when divided
  by m."
  [b e m]
  (letfn [(f [b e m]
             (let [o (order b m)
                   t (mod-tet b (dec e) o)]
               (mod-pow b t m)))
          (g [b e m d]
             (let [n (quot m d)
                   t (mod-tet b e n)
                   i (mod-pow b (dec (totient n)) n)
                   u (mod (* t i) n)]
               (mod (* b u) m)))]
    (cond
      (= m 1) 0
      (= e 1) (mod b m)
      :default (let [d (gcd b m)]
                 (cond
                   (= d 1) (f b e m)
                   (= d m) 0
                   :default (g b e m d))))))

(defn primitive-root?
  "Returns true if a is a primitive root modulo m; false otherwise."
  [a m]
  (let [xs (map #(mod-pow a % m) (range 1 m))
        ys (drop-while #(not= 1 %) xs)]
    (and (= (count ys) 1) (= (first ys) 1))))
