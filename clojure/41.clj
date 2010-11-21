; 7652413
; 1780.55user 102.25system 35:59.98elapsed 87%CPU (0avgtext+0avgdata 0maxresident)k
; 144inputs+16outputs (3major+168277minor)pagefaults 0swaps

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

; This solution can stand to be optimized.  The answer is 7652413 through
; verification with the Project Euler website, but it takes over an hour to
; find it.
(loop [ps seqs/primes]
  (let [p (first ps)]
    (do
      (when (pandigital? p)
        (swap! best (fn [x] p)))
      (if (> p 123456789)
        (println (deref best))
        (recur (rest ps))))))
