(displayln
  (let* ((a (apply + (map (curryr expt 2) (range 1 101))))
         (b (apply + (range 1 101))))
    (- (* b b) a)))
