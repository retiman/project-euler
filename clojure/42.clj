(require '[clojure.contrib.str-utils2 :as su])

(def words
  (map #(su/replace % #"\"" "")
       (su/split (slurp "../data/42.txt") #",")))

(defn t [n]
  (quot (* n (inc n)) 2))
