; Takes an ungodly amount of time to find the solution of 7652413

(require '[clojure.contrib.lazy-seqs :as seqs])

(def best (atom 0))

(defn pandigits [n]
  (into #{}
    (map char
      (range (int \1) ((comp inc int first str) n)))))

(def pandigits (memoize pandigits))

(defn pandigital? [n]
  (let [s (str n)
        t (into #{} s)]
    (do
      (println "Checking" n ", best is" (deref best))
      (and (= (count s) (count t))
           (= t (pandigits (count s)))))))

(loop [ps seqs/primes]
  (let [p (first ps)]
    (do
      (when (pandigital? p)
        (swap! best (fn [x] p)))
      (if (> p 123456789)
        (println (deref best))
        (recur (rest ps))))))
