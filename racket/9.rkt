; Problem #9: https://projecteuler.net/problem=9

; Because a < b < c, it stands to reason that a <= 1000 / 3 (for example, if
; a >= 333, there is no way for the inequality to hold). Furthermore, this
; constrains b to being less than (1000 - a) / 2.
(for* ((a (range 1 333))
       (b (range a (/ (- 1000 a) 2))))
  (let ((c (- 1000 a b)))
    (when (= (+ (* a a) (* b b)) (* c c))
        (displayln (* a b c)))))
