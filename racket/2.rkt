(require "lib/core.rkt")
(require "lib/number-theory.rkt")

(displayln
  (apply + (filter even? (stream-takef fibs (curryr < 4000000)))))
