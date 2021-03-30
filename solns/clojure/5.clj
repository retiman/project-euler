(defn gcd
  ([a b] (if (zero? b) a (gcd b (rem a b))))
  ([a b & more] (reduce gcd (conj more (gcd a b)))))

(defn lcm
  ([a b] (* a (/ b (gcd a b))))
  ([a b & more] (reduce lcm (conj more (lcm a b)))))

(def result (reduce lcm (range 1 20)))

(println result)
(assert (= result 232792560))
