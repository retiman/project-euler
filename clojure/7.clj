(load-file "lib/core.clj")
(use '[lib.core :only (load-primes)])

(def primes (load-primes "../data/primes.txt"))
(println (last (take 10001 primes)))
