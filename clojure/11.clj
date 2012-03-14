; 70600674
; 2.04user 0.14system 0:02.31elapsed 94%CPU (0avgtext+0avgdata 0maxresident)k
; 488inputs+0outputs (0major+14499minor)pagefaults 0swaps

(load-file "lib/core.clj")
(use '[clj-euler.core :only (parse-int)])
(use '[clojure.string :only (split-lines split)])

(def matrix
  (to-array-2d
    ((comp (fn [x] (map #(map parse-int %) x))
           (fn [x] (map #(split % #"\s+") x))
           split-lines
           slurp)
       "../data/11.txt")))

(defn horizontal-product [i j]
  (try (reduce * (map #(aget matrix i (+ j %)) (range 4)))
    (catch RuntimeException e 0)))

(defn vertical-product [i j]
  (try (reduce * (map #(aget matrix (+ i %) j) (range 4)))
    (catch RuntimeException e 0)))

(defn diagonal-up-product [i j]
  (try (reduce * (map #(aget matrix (- i %) (+ j %)) (range 4)))
    (catch RuntimeException e 0)))

(defn diagonal-down-product [i j]
  (try (reduce * (map #(aget matrix (+ i %) (+ j %)) (range 4)))
    (catch RuntimeException e 0)))

(println
  (apply max
    (flatten
      (for [i (range 20)
            j (range 20)]
        (list (horizontal-product i j)
              (vertical-product i j)
              (diagonal-up-product i j)
              (diagonal-down-product i j))))))
