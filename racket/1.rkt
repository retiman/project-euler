; 233168
; 0.24user 0.03system 0:00.29elapsed 98%CPU (0avgtext+0avgdata 40048maxresident)k
; 0inputs+0outputs (0major+12038minor)pagefaults 0swaps

(display
  (foldl +
         0
         (filter (lambda (n)
                   (or (zero? (modulo n 3))
                       (zero? (modulo n 5))))
           (stream->list (in-range 1000)))))
(newline)
