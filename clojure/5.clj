(defn gcd
  ([a b] (if (zero? b) a (gcd b (rem a b))))
  ([a b & more] (reduce gcd (conj more (gcd a b)))))

(defn lcm
  ([a b] (* a (/ b (gcd a b))))
  ([a b & more] (reduce lcm (conj more (lcm a b)))))

(println (reduce lcm (range 1 20)))
