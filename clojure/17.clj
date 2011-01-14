; 21124
; 1.66user 0.16system 0:01.54elapsed 118%CPU (0avgtext+0avgdata 0maxresident)k
; 0inputs+0outputs (0major+13790minor)pagefaults 0swaps

(def word
  {1 "one"
   2 "two"
   3 "three"
   4 "four"
   5 "five"
   6 "six"
   7 "seven"
   8 "eight"
   9 "nine"
   10 "ten"
   11 "eleven"
   12 "twelve"
   13 "thirteen"
   14 "fourteen"
   15 "fifteen"
   16 "sixteen"
   17 "seventeen"
   18 "eighteen"
   19 "nineteen"
   20 "twenty"
   30 "thirty"
   40 "forty"
   50 "fifty"
   60 "sixty"
   70 "seventy"
   80 "eighty"
   90 "ninety"})

(defn say [n]
  (cond
    (= n 1000)
      "one thousand"
    (and (>= n 100) (not (zero? (rem n 100))))
      (str (word (quot n 100)) " hundred and " (say (rem n 100)))
    (and (>= n 100) (zero? (rem n 100)))
      (str (word (quot n 100)) " hundred")
    (and (>= n 20) (not (zero? (rem n 10))))
      (str (word (- n (rem n 10))) " " (say (rem n 10)))
    (and (>= n 20) (zero? (rem n 10)))
      (word (- n (rem n 10)))
    :default
      (word n)))

(println
  (reduce +
    (map count
      (for [w (map say (range 1 1001))]
        (filter #(not (= \space %)) w)))))
