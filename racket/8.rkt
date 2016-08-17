; Problem #8: https://projecteuler.net/problem=8

(require "lib/core.rkt")

(define data
  (apply string-append (file->lines "../data/8.txt")))

(define (char-at data i)
  (char->integer* (string-ref data i)))

(displayln
  (apply max
    (for/list ((i (range 1 (- (string-length data) 4))))
      (apply * (map (curry char-at data) (range i (+ i 5)))))))
