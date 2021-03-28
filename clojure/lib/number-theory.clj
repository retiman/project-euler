(load-file "lib/core.clj")
(ns lib.number-theory
  (:refer-clojure :exclude
    (+
     *
     bit-and
     bit-not
     bit-or
     bit-shift-left
     bit-shift-right
     bit-xor
     dec
     inc))
  (:use
    [clojure.set :only (union)])
  (:require
    [clojure.string :as s]))
(use '[lib.core])

(declare
  choose
  combinations
  divisors
  divisors-
  fact
  gcd
  lcm
  load-primes
  mod-pow
  mod-tet
  order
  order-
  permute
  prime?
  prime-factors
  primitive-root?
  probable-prime?
  sigma
  sigma*
  tau
  tau*
  totient
  totient-)

; Returns the number of combinations of k elements from a set of n elements.
(defn choose
  [n r]
  (if (< n r) 0 (quot (permute n r) (fact r))))

; Generates combinations of a list.
(defn combinations
  [xs k]
  (cond
    (= k 0) '(())
    (empty? xs) '()
    :else (concat (map
                    #(cons (first xs) %)
                    (combinations (rest xs) (dec k)))
                  (combinations (rest xs) k))))

; Returns the digital root of n.
(defn digital-root
  [n]
  (- n (* (quot n 9) 9)))

; Returns the set of divisors of n, including 1 and n itself.  This uses a
; naive algorithm, but memoizes the result.
(defn divisors-
  [n]
  (let [xs (filter #(zero? (mod n %)) (range 2 (inc (isqrt n))))
        ys (map #(quot n %) xs)]
    (union #{1} #{n} (set xs) (set ys))))
(def divisors (memoize divisors-))

; Returns the factorial of n.
(defn fact
  [n]
  (permute n n))

; Returns the greatest common divisor of two numbers.
(defn gcd
  [a b]
  (if (zero? b) a (recur b (mod a b))))

; Returns the lowest common denominator of two numbers.
(defn lcm
  [a b]
  (* a (/ b (gcd a b))))

; Load primes from the pre-existing primes file.
(defn load-primes
  [file]
  (map parse-long (s/split-lines (slurp file))))

; Returns the remainder of b raised to the e-th power when divided by m.
(defn mod-pow
  [b e m]
  (let [f (fn [a b e]
            (if (<= e 0)
              a
              (let [t (if (= (bit-and e 1) 1) (mod (* a b) m) a)]
                (recur t (mod (* b b) m) (bit-shift-right e 1)))))]
    (f 1 b e)))

; Returns the remainder of b exponentiated by itself, e times, when divided by
; m.
;
; See https://en.wikipedia.org/wiki/Tetration
(defn mod-tet
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

; Returns the order of a modulo m.  The order is the smallest positive integer k
; such that a to the k-th power is congruent to 1 modulo m.
;
; Note that the order does not exist if a and m are not relatively prime.
;
; See https://en.wikipedia.org/wiki/Multiplicative_order
(defn order-
  [a m]
  (if (not= (gcd a m) 1)
    (throw (new IllegalArgumentException (str [a m])))
    (let [phi (totient m)
          ds (divisors phi)]
      (first (drop-while #(> (mod-pow a % m) 1) ds)))))
(def order (memoize order-))

; Returns the permutations of a collection.
;
; See https://en.wikipedia.org/wiki/Permutation
(defn permutations [xs]
  (if (= 1 (count xs))
    (list xs)
    (for [head xs
          tail (permutations (disj (set xs) head))]
      (cons head tail))))

; Returns the number of permutations of r distinct elements from a set of n
; elements.
;
; See https://en.wikipedia.org/wiki/Permutation
(defn permute
  [n r]
  (if (zero? r) 1 (reduce * (range n (- n r) -1))))

; Returns true if n is prime; false otherwise.
(defn prime?
  [n]
  (or (= n 2)
      (= (count (divisors n)) 2)))

; Returns the prime factors of n.
;
; See https://en.wikipedia.org/wiki/Integer_factorization
(defn prime-factors
  [n]
  (filter prime? (divisors n)))

; Returns true if a is a primitive root modulo m; false otherwise.
;
; See https://en.wikipedia.org/wiki/Primitive_root_modulo_n
(defn primitive-root?
  [a m]
  (let [xs (map #(mod-pow a % m) (range 1 m))
        ys (drop-while #(not= 1 %) xs)]
    (and (= (count ys) 1) (= (first ys) 1))))

; Returns true if n is probably prime.
;
; See https://en.wikipedia.org/wiki/Probable_prime
(defn probable-prime?
  ([n] (probable-prime? n 10))
  ([n certainty] (. (bigint n) isProbablePrime certainty)))

; Returns the sum of divisors of n, including n.
;
; See https://en.wikipedia.org/wiki/Divisor_function
(defn sigma
  [n]
  (reduce + (divisors n)))

; Returns the sum of divisors of n, excluding n.
;
; See https://en.wikipedia.org/wiki/Divisor_function
(defn sigma*
  [n]
  (- (sigma n) n))

; Returns the number of divisors of n, including n.
;
; See https://en.wikipedia.org/wiki/Divisor_function
(defn tau
  [n]
  (count (divisors n)))

; Returns the number of divisors of n, excluding n.
;
; See https://en.wikipedia.org/wiki/Divisor_function
(defn tau*
  [n]
  (- (tau n) 1))

; Returns the totient of n; the number of positive integers less than or equal
; to n that are relatively prime to n.
;
; See https://en.wikipedia.org/wiki/Euler%27s_totient_function
(defn totient-
  [n]
  (cond
    (= n 1) 0
    :default (reduce (fn [a b] (* (/ a b) (dec b)))
                     n
                     (prime-factors n))))
(def totient (memoize totient-))
