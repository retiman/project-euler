(require "lib/core.rkt")
(require "lib/number-theory.rkt")

(define limit (for/sum ((i (in-range 1 10)))
                (log10 i)))

(define max-digits
  (letrec ((loop (λ (digits)
                   (if (< (- digits 1 (log10 digits)) limit)
                     (loop (add1 digits))
                     (sub1 digits)))))
    (loop 1)))

(define max-factorion
  (* (factorial 9) max-digits))

(displayln
  (for/sum ((n (range 3 (add1 max-factorion)))
            #:when (factorion? n))
    n))