(require "lib/number-theory.rkt")

(define (sigma* n)
  (- (sigma n) n))

(define limit 28123)

(define numbers
  (list->vector (range (add1 limit))))

(define abundants
  (list->vector (filter (λ (n) (> (sigma* n) n)) (range 1 (add1 limit)))))

(for* ((i (range (vector-length abundants)))
       (j (range i (vector-length abundants))))
  (let ((n (+ (vector-ref abundants i) (vector-ref abundants j))))
    (when (<= n limit)
      (vector-set! numbers n 0))))

(displayln (for/sum ((n numbers) #:when (not (zero? n))) n))