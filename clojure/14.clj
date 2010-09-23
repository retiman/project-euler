; JAVA_OPTS="-Xmx1024M" time clojure 14.clj
; 837799
; 35.67user 0.95system 0:23.78elapsed 153%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+64outputs (1major+306196minor)pagefaults 0swaps

(defn collatz-length [n]
  (let [length (fn [n acc]
                 (cond
                   (= n 1) acc
                   (even? n) (recur (/ n 2) (inc acc))
                   (odd? n) (recur (+  1 (* 3 n)) (inc acc))))]
    (length n 0)))

(def memoized-collatz-length (memoize collatz-length))

; In Clojure 1.1.0, sets could be constructed with duplicate elements ignored,
; and hash-maps could be constructed with duplicated keys, with the last key's
; value overriding previous values.
;
; In Clojure 1.2.0, this feature was removed (presumably to help users avoid
; typos).  Sets have a function called 'into' that allowed you to construct
; sets with duplicate values, but hash-maps seem to be missing an analogous
; function (or if not, I do not know it).
;
; However, sorted-map does not have this duplicate key guard, so a sorted-map
; is being used here instead.
(let [h (apply sorted-map
          (flatten
            (map #(vector (memoized-collatz-length %) %) (range 1 1000000))))
      m (apply max (keys h))
      r (h m)]
  (println r))
