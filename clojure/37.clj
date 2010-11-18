; 748317
; 25.55user 0.65system 0:23.03elapsed 113%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+0outputs (0major+89427minor)pagefaults 0swaps

(use '[clj-pelib.math :only (prime?)])
(use '[clojure.contrib.lazy-seqs :only (primes)])

(defn left-truncatable?
  ([p]
    (and (prime? p)
         (every? #(left-truncatable? p %)
                 (range 1 (count (str p))))))
  ([p n]
    (let [q (Integer/parseInt (apply str (drop n (str p))))]
      (prime? q))))

(defn right-truncatable?
  ([p]
    (and (prime? p)
         (every? #(right-truncatable? p %)
                 (range 1 (count (str p))))))
  ([p n]
    (let [q (Integer/parseInt (apply str (take (- (count (str p)) n) (str p))))]
      (prime? q))))

(defn truncatable?
  [p]
  (and (left-truncatable? p) (right-truncatable? p)))

(defn f
  ([ps]
    (f ps ()))
  ([ps ts]
    (let [p (first ps)]
      (cond
        (< p 11) (recur (rest ps) ts)
        (= (count ts) 11) ts
        :default (if (truncatable? p)
                   (recur (rest ps) (cons p ts))
                   (recur (rest ps) ts))))))

(println
  (apply + (f primes)))
