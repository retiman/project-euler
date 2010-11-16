; JAVA_OPTS=""-Xmx1024M"" time clojure 188.clj
; 95962097
; 3.35user 0.25system 0:02.85elapsed 126%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+16outputs (0major+29145minor)pagefaults 0swaps

(defn order
  [a m]
  (let [f (fn [b n]
            (cond
              (= n (dec m)) n
              (= b 1)       n
              :default      (recur (mod (* a b) m ) (inc n))))]
    (f (mod a m) 1)))

(defn mod-exp
  [b e m]
  (let [f (fn [a b e]
            (if (<= e 0)
              a
              (let [t (if (= (bit-and e 1) 1) (mod (* a b) m) a)]
                (recur t (mod (* b b) m) (bit-shift-right e 1)))))]
    (f 1 b e)))

(defn mod-tet
  [b e m]
  (cond
    (= m 1)  0
    (= e 1)  (mod b m)
    :default (let [o (order b m)
                   t (mod-tet b (dec e) o)]
               (mod-exp b t m))))

(println (mod-tet 1777 1855 100000000))
