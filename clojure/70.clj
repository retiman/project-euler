; 8319823
; 29.82user 0.95system 0:22.83elapsed 134%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+16outputs (0major+187686minor)pagefaults 0swaps

(load-file "lib/core.clj")
(use
  '[clojure.math.combinatorics]
  '[clj-euler.core :only (isqrt load-primes)])

(def primes
  (load-primes "../data/primes.txt"))

(def limit (int 1e7))

; Search around the radius of (sqrt 1e7)
(def ps
  (take-while #(<= % (* 2 (inc (isqrt limit)))) primes))

; Create pairs for semi-primes
(def pairs
  (combinations ps 2))

(defn permutation?
  "Returns true if a's digits are a permutation of b's."
  [a b]
  (let [digits #(sort (into [] (str %)))]
    (= (digits a) (digits b))))

(defn phi
  "Calculates the totient of a semi-prime created from p and q."
  [p q]
  (* (dec p) (dec q)))

(defn f
  "Creates a map entry of n/phi(n) -> [p q]."
  [pair]
  (let [p (first pair)
        q (second pair)
        n (* p q)]
    [(/ n (phi p q)) [p q]]))

(defn g
  "Returns true if the totient of the semi-prime generated from [p q] is a
  permutation of that semi-prime."
  [pair]
  (let [p (first pair)
        q (second pair)
        n (* p q)]
    (permutation? n (phi p q))))

; Create a map of n/phi(n) -> [p q], filtering out semi-primes who are
; larger than 1e7
(def h
  (filter #(<= (apply * (second %)) 10000000)
          (apply merge (cons {} (map f pairs)))))

(let [entry (first (drop-while #(not (g (second %))) (sort h)))
      pair (second entry)
      p (first pair)
      q (second pair)]
  (println (* p q)))
