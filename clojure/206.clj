(load-file "lib/core.clj")
(use '[lib.core :only (isqrt)])

(doseq [s '(+ *)]
    (ns-unmap 'user s))
(def + +')
(def * *')

(println
  (loop [n (inc (isqrt 19293949596979899))]
    (let [k (* n n)]
      (if (re-matches #"1\d2\d3\d4\d5\d6\d7\d8\d9" (str k))
        (* n 10)
        (recur (- n 2))))))
