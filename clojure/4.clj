(defn is-palindrome?
  "Returns true if n is a palindrome; false otherwise."
  [n]
  (let [s (str n)]
    (= s (apply str (reverse s)))))

(println
  (reduce max
    (for [i (range 999 1 -1)
          j (range i   1 -1)
          :let [x (* i j)]
          :when (is-palindrome? x)]
      x)))
