(require "lib/core.rkt")

(displayln
  (letrec ((f (λ (a b) (stream-cons a (f b (+ a b)))))
           (fibs (f 0 1)))
    (apply + (filter even? (stream-takef fibs (λ (n) (< n 4000000)))))))
