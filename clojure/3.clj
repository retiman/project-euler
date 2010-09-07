; JAVA_OPTS="-Xmx1024M" time clojure 3.clj
; 6857.0
; 12.56user 0.36system 0:11.81elapsed 109%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+0outputs (0major+50162minor)pagefaults 0swaps

(use 'clojure.set)
(use 'clojure.contrib.math)

(defn fermat-factors [n]
  (if (= 0 (rem n 2))
    #{n (/ n 2)}
    (loop [a (ceil (sqrt n))]
      (let [b (- (* a a) n)
            s (sqrt b)]
        (if (= s (round s))
          #{(- a s) (+ a s)}
          (recur (inc a)))))))

; Here's a fun thing about Clojure:
; user=> (contains? #{1.0} 1)
; false
; user=> (contains? #{1.0} (double 1))
; true
; user=> (contains? #{(long 1)} 1)
; false
; So unless I want to put casts *everywhere*, I think I have to make the
; factors simply a set of ints.
(defn prime-factors [n]
  (let [factors (set (map int (fermat-factors n)))]
    (if (contains? factors 1)
      (disj factors 1)
      (reduce union (map prime-factors factors)))))

(println (reduce max (prime-factors 600851475143)))
