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
