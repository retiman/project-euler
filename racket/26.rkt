(require "lib/number-theory.rkt")

(define numbers
  (filter (λ (n) (and (not (divides? n 2)) (not (divides? n 5))))
          (range 999 1 -1)))

(define (ord* a m)
  (define (loop b lst)
    (if (or (= b 1) (= (length lst) 1))
      (car lst)
      (loop (modulo (* a b) m) (cdr lst))))
  (loop (modulo a m) (range 1 m)))

(define (max-period best numbers)
  (if (empty? numbers)
    best
    (let* ((n (first numbers))
           (t (ord* 10 n)))
      (cond ((= t (sub1 n)) (cons n t))
            ((> t (cdr best)) (max-period (cons n t) (rest numbers)))
            (else (max-period best (rest numbers)))))))

(displayln (car (max-period (cons 0 0) numbers)))
