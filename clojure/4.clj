; 906609
; 7.16user 0.30system 0:06.11elapsed 122%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+0outputs (0major+44153minor)pagefaults 0swaps

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
