(use '[cemerick.pomegranate :only (add-dependencies)])

(add-dependencies
  :coordinates
    '[[org.clojure/math.numeric-tower "0.0.1"]
      [org.clojure/math.combinatorics "0.0.2"]
      [com.lousycoder/clj-euler "0.0.1"]])
