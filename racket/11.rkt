(require math/matrix)

(define (line->vector line)
  (for/vector ((e (regexp-split #px" " line)))
    (string->number e)))

(define m
  (vector*->matrix
    (for/vector ((line (file->lines "../data/11.txt")))
      (line->vector line))))

(define (horizontal-product i j)
  (with-handlers
    ((exn:fail? (const 0)))
    (for/product ((k (in-range 4)))
                 (matrix-ref m i (+ j k)))))

(define (vertical-product i j)
  (with-handlers
    ((exn:fail? (const 0)))
    (for/product ((k (in-range 4)))
                 (matrix-ref m (+ i k) j))))

(define (diagonal-up-product i j)
  (with-handlers
    ((exn:fail? (const 0)))
    (for/product ((k (in-range 4)))
                 (matrix-ref m (- i k) (+ j k)))))

(define (diagonal-down-product i j)
  (with-handlers
    ((exn:fail? (const 0)))
    (for/product ((k (in-range 4)))
                 (matrix-ref (+ i k) (+ j k)))))

(displayln
  (apply max
    (flatten
      (for*/list ((i (in-range 20))
                  (j (in-range 20)))
        (list (horizontal-product i j)
              (vertical-product i j)
              (diagonal-up-product i j)
              (diagonal-down-product i j))))))
