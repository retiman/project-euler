(import [java.util Calendar])

(def cal (Calendar/getInstance))

(def sundays (atom 0))

(doseq [year (range 1901 2001)
        month (range 0 12)]
  (.set cal year month 1)
  (when (= (.get cal Calendar/DAY_OF_WEEK) Calendar/SUNDAY)
    (swap! sundays inc)))

(def result @sundays)

(println result)
(assert (= result 171))
