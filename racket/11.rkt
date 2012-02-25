; 70600674
; 0.30user 0.02system 0:00.33elapsed 99%CPU (0avgtext+0avgdata 39140maxresident)k
; 0inputs+0outputs (0major+13734minor)pagefaults 0swaps

(define matrix
  (list->vector
    (map
      (compose
        list->vector
        (lambda (s)
          (map string->number (regexp-split #px" " s))))
      (file->lines "../data/11.txt"))))

(define (vget matrix i j)
  (vector-ref (vector-ref matrix i) j))

(define (horizontal-product i j)
  (with-handlers
    ((exn:fail?
       (lambda (e) 0)))
    (foldl * 1
      (map (lambda (k) (vget matrix i (+ j k)))
           (stream->list (in-range 4))))))

(define (vertical-product i j)
  (with-handlers
    ((exn:fail?
       (lambda (e) 0)))
    (foldl * 1
      (map (lambda (k) (vget matrix (+ i k) j))
           (stream->list (in-range 4))))))

(define (diagonal-up-product i j)
  (with-handlers
    ((exn:fail?
       (lambda (e) 0)))
    (foldl * 1
      (map (lambda (k) (vget matrix (- i k) (+ j k)))
           (stream->list (in-range 4))))))

(define (diagonal-down-product i j)
  (with-handlers
    ((exn:fail?
       (lambda (e) 0)))
    (foldl * 1
      (map (lambda (k) (vget matrix (+ i k) (+ j k)))
           (stream->list (in-range 4))))))

(display
  (apply
    max
    (flatten
      (for*/list
        ((i (in-range 20))
         (j (in-range 20)))
        (list (horizontal-product i j)
              (vertical-product i j)
              (diagonal-up-product i j)
              (diagonal-down-product i j))))))
(newline)
