(require "lib/core.rkt")

(define (digital-sum-5 n)
  (for/sum ((c (string->list (number->string n))))
    (expt (char->integer* c) 5)))

(define limit
  (let* ((x (expt 9 5))
         (s (stream-takef (in-naturals) (λ (n) (<= (expt 10 (sub1 n)) x)))))
    (* (stream-length s) x)))

(displayln
  (for/sum ((i (range 10 limit))
            #:when (= i (digital-sum-5 i)))
    i))
