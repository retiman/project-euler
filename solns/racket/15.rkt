#lang racket
(require rackunit)
(require "lib/core.rkt")
(require "lib/number-theory.rkt")


; Starting at the upper left, one must move down exactly 20 times, and right
; exactly 20 times in order to reach the bottom right. Represent the downward
; movement as a 'D' and the rightward movement as an 'R', then the number of
; routes to the bottom right is equal to the number of permutations of a 'word'
; with 20 D's and 20 R's.
;
; This can be viewed as a multiset permutation whose cardinality is the
; multinomial coefficient.
;
; See https://en.wikipedia.org/wiki/Permutation#Permutations_of_multisets
(define result
  (let* ((n (factorial (+ 20 20)))
         (d (* (factorial 20) (factorial 20)))
         (r (/ n d)))
    r))

(displayln result)
(check-equal? result 137846528820)
