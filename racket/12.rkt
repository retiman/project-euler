(require "lib/core.rkt")
(require "lib/number-theory.rkt")

(define (f n i)
  (if (> (tau n) 500)
    n
    (f (+ n i) (add1 i))))

(displayln (f 3 3))
