(require "lib/number-theory.rkt")

(define (sigma* n)
  (- (sigma n) n))

(displayln
  (for/sum ((a (in-range 2 10001)))
    (let ((b (sigma* a)))
      (if (and (> a b) (= (sigma* b) a))
        (+ a b)
        0))))
