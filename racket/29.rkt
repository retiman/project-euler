(require "lib/core.rkt")

(displayln
  (set-length
    (for*/set ((a (in-range 2 101))
              (b (in-range 2 101)))
      (expt a b))))
