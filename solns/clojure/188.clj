(defn order
  [a m]
  (let [f (fn [b n]
            (cond
              (= n (dec m)) n
              (= b 1)       n
              :else         (recur (mod (* a b) m ) (inc n))))]
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
    :else    (let [o (order b m)
                   t (mod-tet b (dec e) o)]
               (mod-exp b t m))))

(def result (mod-tet 1777 1855 100000000))

(println result)
(assert (= result 95962097))
