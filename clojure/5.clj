; JAVA_OPTS="-Xmx1024M" time clojure 5.clj
; 232792560
; 0.89user 0.03system 0:00.65elapsed 143%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+64outputs (1major+13974minor)pagefaults 0swaps

(defn gcd
  ([a b] (if (= b 0) a (gcd b (rem a b))))
  ([a b & more] (reduce gcd (conj more (gcd a b)))))

(defn lcm
  ([a b] (* a (/ b (gcd a b))))
  ([a b & more] (reduce lcm (conj more (lcm a b)))))

(println (reduce lcm (range 1 20)))
