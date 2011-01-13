(use '[clojure.contrib.lazy-seqs :only (primes)])
(defn main [& args]
  (doseq [p (take-while #(< % (Long/parseLong (first args)) primes))]
    (println p)))
