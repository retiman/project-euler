(require "lib/core.rkt")
(require "lib/number-theory.rkt")

(displayln
  (letrec ((loop (λ (n i) (if (> (τ n) 500) n (loop (+ n i) (add1 i))))))
    (loop 3 3)))
