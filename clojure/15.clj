(doseq [s '(+ *)]
  (ns-unmap 'user s))
(def + +')
(def * *')

(defn fact [n] (reduce * (range 1 n)))

(let [n (fact (+ 20 20))
      d (* (fact 20) (fact 20))
      r (/ n d)]
  (println r))
