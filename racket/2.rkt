(require "lib/core.rkt")
(require "lib/number-theory.rkt")

(displayln
  (apply + (filter even? (stream-takef fibs (λ (n) (< n 4000000))))))
