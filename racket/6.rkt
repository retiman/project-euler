; 25164150
; 0.27user 0.01system 0:00.29elapsed 98%CPU (0avgtext+0avgdata 38824maxresident)k
; 0inputs+0outputs (0major+11890minor)pagefaults 0swaps

(let* ((a (foldl + 0 (map (lambda (x) (* x x)) (stream->list (in-range 1 101)))))
       (b (foldl + 0 (stream->list (in-range 1 101))))
       (r (- (* b b) a)))
  (display r))
(newline)
