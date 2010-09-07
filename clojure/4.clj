; JAVA_OPTS="-Xmx1024M" time clojure 4.clj
; 906609
; 7.16user 0.30system 0:06.11elapsed 122%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+0outputs (0major+44153minor)pagefaults 0swaps

(defn is-palindrome? [n]
  (let [s (.toString n)]
    (= s (apply str (reverse s)))))

(defn all-palindromes []
  (for [i (range 999 1 -1)
        j (range i   1 -1)
        :when (let [x (* i j)] (is-palindrome? x))]
    (* i j)))

(println (reduce max (all-palindromes)))
