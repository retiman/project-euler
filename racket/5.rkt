; time racket -r 5.rkt
; 232792560
; 0.23user 0.04system 0:00.29elapsed 98%CPU (0avgtext+0avgdata 40132maxresident)k
; 0inputs+0outputs (0major+12191minor)pagefaults 0swaps

(display
  (foldl lcm 1 (stream->list (in-range 1 20))))
(newline)
