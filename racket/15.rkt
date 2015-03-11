(require "lib/number-theory.rkt")

(displayln
  (let* ((n (factorial (+ 20 20)))
         (d (* (factorial 20) (factorial 20)))
         (r (/ n d)))
    r))
