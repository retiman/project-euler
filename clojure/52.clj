; 142857
; 8.84user 0.48system 0:06.81elapsed 136%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+8outputs (0major+81218minor)pagefaults 0swaps

(defn same-digits? [a b & more]
  (let [xs (concat [a b] more)]
    (apply = (map #(into #{} (str %)) xs))))

(defn products [n]
  (map #(* n %) (range 1 (inc 6))))

(def xs
  (map products (iterate inc 1)))

(def ys
  (drop-while #(not (apply same-digits? %)) xs))

(println (first (first ys)))
