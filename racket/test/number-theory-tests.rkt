#lang racket

(provide number-theory-tests)

(require rackunit)
(require "../lib/number-theory.rkt")

(define number-theory-tests
  (test-suite
    "Tests for number-theory.rkt"

    (check-equal? (coprime? 1 1) #t "1 and 1 are coprime")
    (check-equal? (coprime? 2 1) #t "2 and 1 are coprime")
    (check-equal? (coprime? 5 7) #t "5 and 7 are coprime")
    (check-equal? (coprime? 15 3) #f "15 and 3 are not coprime")
    (check-equal? (coprime? 4 2) #f "4 and 2 are coprime")

    (check = (digits 1) 1 "1 has 1 digit")
    (check = (digits 72) 2 "72 has 2 digits")
    (check = (digits 234) 3 "234 has 3 digits")
    (check = (digits 0321) 3 "0321 has 3 digits")

    (check-equal? (divides? 2 1) #f "2 does not divide 1")
    (check-equal? (divides? 1 2) #t "1 does divide 2")
    (check-equal? (divides? 5 20) #t "5 does divide 20")
    (check-equal? (divides? 7 20) #f "7 does not divide 20")

    (check-equal? (divisors 1) (set 1) "divisors of 1")
    (check-equal? (divisors 2) (set 1 2) "divisors of 2")
    (check-equal? (divisors 15) (set 1 3 5 15) "divisors of 15")
    (check-equal? (divisors 2015) (set 1 5 13 31 65 155 403 2015)
                  "divisors of 2015")

    (check-equal? (divisors* 1) (set) "divisors* of 1")
    (check-equal? (divisors* 2) (set 1) "divisors* of 2")
    (check-equal? (divisors* 15) (set 1 3 5) "divisors* of 15")
    (check-equal? (divisors* 2015) (set 1 5 13 31 65 155 403)
                  "divisors* of 2015")

    (check = (factorial 0) 1 "factorial of 0")
    (check = (factorial 1) 1 "factorial of 1")
    (check = (factorial 5) 120 "factorial of 5")
    (check = (factorial 10) 3628800 "factorial of 10")

    (check-equal? (factorion? 1) #t "1 is a factorion")
    (check-equal? (factorion? 2) #t "2 is a factorion")
    (check-equal? (factorion? 145) #t "145 is a factorion")
    (check-equal? (factorion? 146) #f "146 is not a factorion")

    (check-equal? (stream-ref fibs 0) 0 "first fibonacci number")
    (check-equal? (stream-ref fibs 1) 1 "second fibonacci number")
    (check-equal? (stream-ref fibs 2) 1 "third fibonacci number")
    (check-equal? (stream-ref fibs 3) 2 "fourth fibonacci number")

    (check = (logarithm 2 64) 6 "log base 2 of 64 is 6")
    ; TODO: More logarithm tests.

    (check = (modular-expt 3 1 2) 1 "residue of 3^1 divided by 2")
    (check = (modular-expt 3 0 9) 1 "residue of 3^0 divided by 9")
    (check = (modular-expt 5 3 13) 8 "residue of 5^3 divided by 13")
    (check = (modular-expt 4 13 497) 445 "residue of 4^13 divided by 497")

    (check = (modular-tetn 3 1 2) (modulo (expt 3 1) 2)
           "residue of 3^^1 divided by 2")
    (check = (modular-tetn 3 2 20) (modulo (expt 3 3) 20)
           "residue of 3^^2 divided by 20")
    (check = (modular-tetn 3 3 345) 312 "residue of 3^^3 divided by 345")
    (check = (modular-tetn 993306745 75707320 1000000000) 884765625
           "residue of 993306745^^75707320 divided by 1000000000")

))
