(load-file "lib/number-theory.clj")
(require
  '[lib.number-theory :refer [load-primes]])


(def primes (load-primes "../data/primes.txt"))
(def result (last (take 10001 primes)))

(println result)
(assert (= result 104743))
