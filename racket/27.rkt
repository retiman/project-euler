(require "lib/number-theory.rkt")

(define ps
  (filter prime? (range 1000)))

(define (f n a b)
  (+ (* n n) (* a n) b))

(define (primes-count a b)
  (for/sum ((n (range b)))
    (if (prime? (f n a b)) 1 0)))

(define m
  (for*/hash ((b (append ps (map (curry * -1) ps)))
              (a (range -1000 1001)))
    (let ((c (primes-count a b)))
      (values c (cons a b)))))

(displayln
  (let ((v (hash-ref m (apply max (hash-keys m)))))
    (* (car v) (cdr v))))
