(require "lib/core.rkt")
(require "lib/number-theory.rkt")

(displayln
  (for/sum ((c (number->string (factorial 100))))
    (char->number c)))
