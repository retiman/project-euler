(require "lib/core.rkt")
(require "lib/number-theory.rkt")

(displayln
  (letrec ((f (λ (n i) (if (> (τ n) 500) n (f (+ n i) (add1 i))))))
    (f 3 3)))
