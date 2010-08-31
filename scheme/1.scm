; time mzscheme -f 1.scm
; 233168
; 0.45user 0.04system 0:00.52elapsed 95%CPU (0avgtext+0avgdata 0maxresident)k
; 16inputs+0outputs (1major+6917minor)pagefaults 0swaps

(define sum
  (lambda (limit)
    (let recur ((i 0))
      (cond ((>= i limit) 0)
            ((= 0 (modulo i 3)) (+ i (recur (+ i 1))))
            ((= 0 (modulo i 5)) (+ i (recur (+ i 1))))
            (else (recur (+ i 1)))))))

(display (sum 1000))
(newline)
