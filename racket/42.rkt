(require srfi/1)

(define (triangle n)
  (quotient (* n (add1 n)) 2))

(define (triangle? n)
  (hash-has-key? triangle-word-scores n))
