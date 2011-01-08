; 7652413
; 137.54user 0.88system 2:21.36elapsed 97%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+24outputs (0major+106307minor)pagefaults 0swaps

(use '[clojure.contrib.lazy-seqs :only (primes)])
(use '[clojure.contrib.combinatorics :only (permutations)])
(use '[clojure.set :only (intersection)])
(require '[clojure.contrib.str-utils2 :as su])

(def parse-int #(Integer/parseInt %))

(def cs
  (map char (range (int \1) ((comp inc int first str) 7))))

; Only numbers up to 7654321 are considered.
; Any pandigital containing digits 1 through 8 is not prime:
; (apply + (range 1 9)) is 36 and thus divisible by 3
; Any pandigital containing digits 1 through 9 is not prime:
; (apply + (range 1 10)) is 45 and thus divisible by 3
(def xs
  (into #{} (take-while #(< % 7654321) primes)))

(def ys
  (into #{} (map #(parse-int (su/join "" %)) (permutations cs))))

(println (apply max (intersection xs ys)))
