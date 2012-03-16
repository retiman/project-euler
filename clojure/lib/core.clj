(use '[cemerick.pomegranate :only (add-dependencies)])

(add-dependencies
  :repositories
    (merge
      cemerick.pomegranate.aether/maven-central
      {"clojars" "http://clojars.org/repo"})
  :coordinates
    '[[org.clojure/math.numeric-tower "0.0.1"]
      [org.clojure/math.combinatorics "0.0.2"]
      [com.lousycoder/clj-euler "2.0.2"]])
