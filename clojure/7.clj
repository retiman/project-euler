; JAVA_OPTS="-Xmx1024M" time clojure 7.clj
; 104729
; 225.65user 1.84system 3:32.83elapsed 106%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+248outputs (1major+190451minor)pagefaults 0swaps

(use '[clojure.contrib.math :only (sqrt)])

(defn lazy-primes3 []
  (letfn [(enqueue [sieve n step]
            (let [m (+ n step)]
              (if (sieve m)
                (recur sieve m step)
                (assoc sieve m step))))
          (next-sieve [sieve candidate]
            (if-let [step (sieve candidate)]
              (-> sieve
                (dissoc candidate)
                (enqueue candidate step))
              (enqueue sieve candidate (+ candidate candidate))))
          (next-primes [sieve candidate]
            (if (sieve candidate)
              (recur (next-sieve sieve candidate) (+ candidate 2))
              (cons candidate
                (lazy-seq (next-primes (next-sieve sieve candidate)
                            (+ candidate 2))))))]
    (cons 2 (lazy-seq (next-primes {} 3)))))

(println (last (take 10001 (lazy-primes3))))
