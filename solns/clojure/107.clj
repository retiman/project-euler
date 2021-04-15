(load-file "lib/core.clj")
(require
  '[clojure.set :as set]
  '[clojure.string :as string]
  '[lib.core :refer [parse-double]])


(def inf Double/POSITIVE_INFINITY)

(def graph
  (let [unsplit-lines (string/split-lines (slurp "../data/107.txt"))
        split-lines (map #(string/split % #",") unsplit-lines)
        parse-element #(if (= "-" %) inf (parse-double %))
        rows (map #(map parse-element %) split-lines)]
    (vec (map vec rows))))

(def vertex-set
  ((comp set range count) graph))

; The cost must be divided by two because blindly summing the matrix
; representation will count each edge twice.
(def total-cost
  (let [sum-row (fn [row] (reduce + (filter #(not (= inf %)) row)))
        sum-graph (reduce + (map sum-row graph))]
    (/ sum-graph 2)))

; Returns the cost of connecting node u to v.
(defn cost
  [edge]
  (let [u (first edge)
        v (last edge)]
    (nth (nth graph u) v)))

; Returns the nodes connected to u by an edge.
(defn neighbors
  [u]
  (set
    (filter #(not (= inf (cost [u %])))
            (range (count graph)))))

; Returns the frontier edges of a set of vertices.
(defn frontier-edges
  [vertices]
  (set
    (for [u vertices
          v (set/difference (neighbors u) vertices)]
      #{u v})))

; Returns the cost of the cheapest frontier edge.
(defn cheapest-edge
  [vertices edges]
  (let [frontier (vec (set/difference (frontier-edges vertices) edges))
        costs (map cost frontier)
        costs-map (zipmap costs frontier)
        min-cost (apply min (keys costs-map))]
    (get costs-map min-cost)))

; Returns an minimum spanning tree calculated by Prim's algorithm.
(def mst
  (loop [vertices #{0}
         edges #{}]
    (if (= vertices vertex-set)
      edges
      (let [edge (cheapest-edge vertices edges)]
        (recur (set/union vertices edge)
               (conj edges edge))))))

(def result
  (let [mst-cost (reduce + (map cost mst))]
    (long (- total-cost mst-cost))))

(println result)
(assert (= result 259679))
