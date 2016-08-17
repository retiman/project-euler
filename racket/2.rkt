(require srfi/41)
(require "lib/number-theory.rkt")

(displayln
  ((compose (curry apply +)
            (curry filter even?)
            stream->list
            (curry stream-take-while (curryr < 4000000)))
     fibs))
