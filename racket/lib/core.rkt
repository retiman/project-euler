(require racket/math)

(define (logb b n)
  (/ (log n) (log b)))

(define (lg n)
  (logb 2 n))

(define (permute n r)
  (if (zero? r)
    1
    (foldl * 1 (stream->list (in-range n (- n r) -1)))))

(define (choose n r)
  (if (< n r)
    0
    (quotient (permute n r) (factorial r))))

(define (factorial n)
  (permute n n))

(define (digital-root n)
  (- n (* (quotient n 9) 9)))
