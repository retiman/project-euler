(load-file "lib/number-theory.clj")
(require
  '[lib.number-theory :refer [load-primes prime?]])


(def primes (load-primes "../data/primes.txt"))

(defn truncate
  "Drops a single digit from the left or right of a number."
  [n direction]
  (let [s (str n)
        k (if (= direction :left)
            (drop 1 s)
            (take (dec (count s)) s))]
    (Integer/parseInt (apply str k))))

(defn truncatable?
  "Returns true if p remains a prime as each digit is truncated from the left
  and from the right."
  ([n]
    (and (truncatable? n :left)
         (truncatable? n :right)))
  ([n direction]
    (and (prime? n)
         (if (< n 10)
           true
           (truncatable? (truncate n direction) direction)))))

(defn f
  "Finds the first 11 primes that are 'truncatable'.  The problem gives us that
  there are only 11 such primes, so there is no need to search further."
  ([ps]
    (f ps ()))
  ([ps ts]
    (let [p (first ps)]
      (cond
        (< p 11) (recur (rest ps) ts)
        (= (count ts) 11) ts
        :else (if (truncatable? p)
                (recur (rest ps) (cons p ts))
                (recur (rest ps) ts))))))

(def result (reduce + (f primes)))

(println result)
(assert (= result 748317))
