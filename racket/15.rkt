(require "lib/core.rkt")

(define (factorial n)
  (for/product ((i (range 1 (add1 n)))) i))

(displayln
  (let* ((n (factorial (+ 20 20)))
         (d (* (factorial 20) (factorial 20)))
         (r (/ n d)))
    r))
