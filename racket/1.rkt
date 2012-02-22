(define (sum limit)
  (let recur ((i 0))
    (cond
      ((>= i limit) 0)
      ((zero? (modulo i 3)) (+ i (recur (+ i 1))))
      ((zero? (modulo i 5)) (+ i (recur (+ i 1))))
      (else (recur (+ i 1))))))

(display (sum 1000))
(newline)
