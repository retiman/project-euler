(declare
  p1
  p2
  p5
  p10
  p20
  p50
  p100
  p200)

(defmacro defp [x y]
  (let [px (symbol (str "p" x))
        py (symbol (str "p" y))]
    `(defn ~px [n#]
       (if (>= n# 0)
         (+ (~px (- n# ~x)) (~py n#))
         0))))

(defn p1 [_n] 1)

(defp 2 1)

(defp 5 2)

(defp 10 5)

(defp 20 10)

(defp 50 20)

(defp 100 50)

(defp 200 100)

(def result (p200 200))

(println result)
(assert (= result 73682))
