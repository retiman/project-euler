(load-file "lib/number-theory.clj")
(require
  '[lib.number-theory :refer [load-primes]])


(def primes (load-primes "../data/primes.txt"))

(defn f [acc ps]
  (let [n (* acc (first ps))]
    (if (> n 1000000)
      acc
      (recur n (rest ps)))))

(def result (f 1 primes))

(println result)
(assert (= result 510510))
