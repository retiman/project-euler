; JAVA_OPTS="-Xmx1024M" time clojure 15.clj
; 137846528820
; 0.90user 0.02system 0:00.65elapsed 141%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+64outputs (1major+13952minor)pagefaults 0swaps

(defn fact [n]
  (let [f (fn [n acc]
            (if (or (zero? n) (= n 1))
              acc
              (recur (dec n) (* n acc))))]
    (f n 1)))

(let [n (fact (+ 20 20))
      d (* (fact 20) (fact 20))
      r (/ n d)]
  (println r))
