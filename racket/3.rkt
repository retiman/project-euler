(require "lib/number-theory.rkt")

(displayln (apply max (set->list (prime-factors 600851475143))))
