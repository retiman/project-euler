(defmacro defp [x y]
  (let [f (str "p" x)
        g (str "p" y)]
    `(defn ~(symbol f) [n#]
       (if (>= n# 0)
         (+ (~(symbol f) (- n# ~x)) (~(symbol g) n#))
         0))))

(defn p1 [n] 1)

(defp 2 1)

(defp 5 2)

(defp 10 5)

(defp 20 10)

(defp 50 20)

(defp 100 50)

(defp 200 100)

(println (p200 200))
