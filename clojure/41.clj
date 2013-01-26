(load-file "lib/core.clj")
(use
  '[clojure.math.combinatorics :only (permutations)]
  '[clojure.set :only (intersection)]
  '[lib.core :only (load-primes parse-int)])
(require '[clojure.string :as su])

(def primes (load-primes "../data/primes.txt"))

(def cs
  (map char (range (int \1) ((comp inc int first str) 7))))

; Only numbers up to 7654321 are considered.
; Any pandigital containing digits 1 through 8 is not prime:
; (apply + (range 1 9)) is 36 and thus divisible by 3
; Any pandigital containing digits 1 through 9 is not prime:
; (apply + (range 1 10)) is 45 and thus divisible by 3
(def xs
  (into #{} (take-while #(<= % 7654321) primes)))

(def ys
  (into #{} (map #(parse-int (su/join "" %)) (permutations cs))))

(println (apply max (intersection xs ys)))
