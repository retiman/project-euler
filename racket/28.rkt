(require "lib/2darray.rkt")

(define (turn heading)
  (match heading
    ('right 'down)
    ('down 'left)
    ('left 'up)
    ('up 'right)))

(define (next i j heading)
  (match heading
    ('right (cons (add1 i) j))
    ('down (cons i (sub1 j)))
    ('left (cons (sub1 i) j))
    ('up (cons i (add1 j)))))

(define (make-spiral n)
  (define (loop m p heading n)
    (let ((i (car p))
          (j (cdr p)))
      (when (2darray-in-bounds? m i j)
        (let* ((heading* (turn heading))
               (p* (next i j heading*))
               (i* (car p*))
               (j* (cdr p*)))
        (2darray-set! m i j n)
        (if (= (2darray-ref m i* j*) 0)
          (loop m p* heading* (add1 n))
          (loop m (next i j heading) heading (add1 n)))))))
  (let ((m (make-2darray n n)))
    (loop m (cons (quotient n 2) (quotient n 2)) 'up 1)
    m))

(define limit 1001)

(define spiral (make-spiral limit))

(displayln
  (sub1
    (for*/sum ((i (in-range limit)))
      (+ (2darray-ref spiral i i)
        (2darray-ref spiral i (- (2darray-num-cols spiral) i 1))))))
