(require "lib/core.rkt")

(displayln (for/sum ((c (number->string (expt 2 1000)))) (char->integer* c)))
