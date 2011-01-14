(use 'clj-pelib.core)
(require '[clojure.contrib.str-utils2 :as su])

(def s
  "75
  95 64
  17 47 82
  18 35 87 10
  20 04 82 47 65
  19 01 23 75 03 34
  88 02 77 73 07 63 67
  99 65 04 28 06 16 70 92
  41 41 26 56 83 40 80 70 33
  41 48 72 33 47 32 37 16 94 29
  53 71 44 65 25 43 91 52 97 51 14
  70 11 33 28 77 73 17 78 39 68 17 57
  91 71 52 38 17 14 91 43 58 50 27 29 48
  63 66 04 68 89 53 67 30 73 16 69 87 40 31
  04 62 98 27 23 09 70 98 73 93 38 53 60 04 23")

(def data
  (atom
    (let [f (comp
              (fn [x] (map vec x))
              (fn [x] (map #(map parse-int %) x))
              (fn [x] (map #(su/split % #" ") x))
              (fn [x] (map su/trim x))
              (fn [x] (su/split-lines x)))]
      (vec (f s)))))

(defn update [data i j v]
  (let [r1 (data i)
        r2 (assoc r1 j (+ (r1 j) v))]
    (assoc data i r2)))

(doseq [i (range (- (count @data) 2) (dec 0) -1)
        j (range 0 (count (@data i)))
        :let [left ((@data (inc i)) j)
              right ((@data (inc i)) (inc j))
              bigger (max left right)]]
   (swap! data #(update % i j bigger)))

(println ((@data 0) 0))
