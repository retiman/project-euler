(require racket/generator)

(define g
  (generator
    ()
    (for* ((a (in-range 1 333))
           (b (in-range a (/ (- 1000 a) 2))))
          (let ((c (- 1000 a b)))
            (when (= (+ (* a a) (* b b))
                     (* c c))
              (yield (* a b c)))))))

(display (g))
(newline)
