(load-file "lib/core.clj")
(use
  '[lib.core :only (load-primes)])

(def primes (load-primes "../data/primes.txt"))

(defn f [acc ps]
  (let [n (* acc (first ps))]
    (if (> n 1000000)
      acc
      (recur n (rest ps)))))

(println (f 1 primes))
