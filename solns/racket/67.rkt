#lang racket
(require rackunit)


(define (2dvector-num-rows a) (vector-length a))

(define (2dvector-num-cols a i)
  (let ((v (vector-ref a i)))
    (length (takef (vector->list v) (lambda (e) (not (= e 0)))))))

(define (2dvector-ref a i j)
  (vector-ref (vector-ref a i) j))

(define (2dvector-set! a i j x)
  (vector-set! (vector-ref a i) j x))

(define input (string-trim (file->string "/data/67.txt")))

(define (string->row s)
  (map string->number (regexp-split #px" " s)))

(define data
  ((compose
     list->vector
     (curry map list->vector)
     (curry map string->row)
     (curry map string-trim)
     (curry regexp-split #px"\n"))
  input))

(for* ((i (range (- (2dvector-num-rows data) 2) (sub1 0) -1))
       (j (range 0 (2dvector-num-cols data i))))
  (let* ((current (2dvector-ref data i j))
         (left (2dvector-ref data (add1 i) j))
         (right (2dvector-ref data (add1 i) (add1 j)))
         (bigger (max left right)))
    (2dvector-set! data i j (+ current bigger))))

(define result (2dvector-ref data 0 0))

(displayln result)
(check-equal? result 7273)
