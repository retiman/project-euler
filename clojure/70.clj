(load-file "lib/core.clj")
(load-file "lib/number-theory.clj")
(use
  '[lib.core :only (isqrt)]
  '[lib.number-theory :only (combinations load-primes)])


(def primes
  (load-primes "../data/primes.txt"))

(def limit (int 1e7))

; Search around the radius of (sqrt 1e7)
(def ps
  (take-while #(<= % (* 2 (inc (isqrt limit)))) primes))

; Create pairs for semi-primes
(def pairs
  (combinations ps 2))

; Returns true if a's digits are a permutation of b's.
(defn permutation?
  [a b]
  (let [digits #(sort (into [] (str %)))]
    (= (digits a) (digits b))))

; Calculates the totient of a semi-prime created from p and q.
(defn phi
  [p q]
  (* (dec p) (dec q)))

; Creates a map entry of n/phi(n) -> [p q].
(defn f
  [pair]
  (let [p (first pair)
        q (second pair)
        n (* p q)]
    [(/ n (phi p q)) [p q]]))

; Returns true if the totient of the semi-prime generated from [p q] is a
; permutation of that semi-prime."
(defn g
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

(def result
  (let [entry (first (drop-while #(not (g (second %))) (sort h)))
        pair (second entry)
        p (first pair)
        q (second pair)]
    (* p q)))

(println result)
(assert (= result 8319823))
