#! /usr/bin/env racket
#lang racket
(require rackunit)
(require "lib/number-theory.rkt")

(define word
  (hash 1 "one"
        2 "two"
        3 "three"
        4 "four"
        5 "five"
        6 "six"
        7 "seven"
        8 "eight"
        9 "nine"
        10 "ten"
        11 "eleven"
        12 "twelve"
        13 "thirteen"
        14 "fourteen"
        15 "fifteen"
        16 "sixteen"
        17 "seventeen"
        18 "eighteen"
        19 "nineteen"
        20 "twenty"
        30 "thirty"
        40 "forty"
        50 "fifty"
        60 "sixty"
        70 "seventy"
        80 "eighty"
        90 "ninety"))

(define (say n)
  (cond
    ((= n 1000)
     "one thousand")
    ((and (>= n 100) (not (divides? 100 n)))
     (string-append (hash-ref word (quotient n 100))
                    " hundred and "
                    (say (remainder n 100))))
    ((and (>= n 100) (divides? 100 n))
     (string-append (hash-ref word (quotient n 100))
                    " hundred"))
    ((and (>= n 20) (not (divides? 10 n)))
     (string-append (hash-ref word (- n (remainder n 10)))
                    " "
                    (say (remainder n 10))))
    ((and (>= n 20) (divides? 10 n))
     (hash-ref word (- n (remainder n 10))))
    (else (hash-ref word n))))

(define result
  (for/sum ((phrase (map say (range 1 1001))))
    (string-length (string-replace phrase " " ""))))

(displayln result)
(check-equal? result 21124)
