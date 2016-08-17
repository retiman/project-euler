(require "lib/core.rkt")
(require "lib/number-theory.rkt")

(define xs
  (map list->integer (permutations (range 1 8))))

(displayln
  (apply max (filter prime? xs)))
