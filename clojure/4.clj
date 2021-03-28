(defn is-palindrome?
  [n]
  (let [s (str n)]
    (= s (apply str (reverse s)))))

(def result
  (reduce max
    (for [i (range 999 1 -1)
          j (range i   1 -1)
          :let [x (* i j)]
          :when (is-palindrome? x)]
      x)))

(println result)
(assert (= result 906609))
