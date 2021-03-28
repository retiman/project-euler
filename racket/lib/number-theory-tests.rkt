#lang racket
(provide number-theory-tests)
(require rackunit)
(require "number-theory.rkt")


(define number-theory-tests
  (test-suite
    "Tests for number-theory.rkt"

    (check-equal? (coprime? 1 1) #t "1 and 1 are coprime")
    (check-equal? (coprime? 2 1) #t "2 and 1 are coprime")
    (check-equal? (coprime? 5 7) #t "5 and 7 are coprime")
    (check-equal? (coprime? 15 3) #f "15 and 3 are not coprime")
    (check-equal? (coprime? 4 2) #f "4 and 2 are coprime")
    (check-equal? (coprime? 1 1) (relatively-prime? 1 1)
                  "relatively-prime? is exported")

    (check = (digits -10) 2 "-10 has 2 digits")
    (check = (digits -1) 1 "-1 has 1 digit")
    (check = (digits 0) 1 "0 has 1 digit")
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

    (check = (next-prime 1) 2 "next prime after 1")
    (check = (next-prime 5) 7 "next prime after 5")
    (check = (next-prime 6) 7 "next prime after 6")
    (check = (next-prime 71) 73 "next prime after 71")

    (check-equal? (next-primes 1 1) '(2) "next 1 prime after 1")
    (check-equal? (next-primes 1 0) '() "next 0 primes after 1")
    (check-equal? (next-primes 2 1) '(3) "next 1 prime after 2")
    (check-equal? (next-primes 1 10) '(2 3 5 7 11 13 17 19 23 29)
           "next 10 primes after 1")

    (check-equal? (next-primes* 1 1) '()
                  "next primes after 1 that are less than or equal to 1")
    (check-equal? (next-primes* 1 2) '(2)
                  "next primes after 1 that are less than or equal to 2")
    (check-equal? (next-primes* 1 3) '(2 3)
                  "next primes after 1 that are less than or equal to 3")
    (check-equal? (next-primes* 1 10) '(2 3 5 7)
                  "next primes after 1 that are less than or equal to 10")

    (check-equal? (nth-prime 0) 2 "the 1st prime is 2")
    (check-equal? (nth-prime 4) 11 "the 5th prime is 11")
    (check-equal? (nth-prime 12) 41 "the 13th prime is 41")
    (check-equal? (nth-prime 18) 67 "the 19th prime is 67")

    (check-equal? (ord 4 7) 3 "the order of 4 modulo 7 is 3")
    (check-equal? (ord 10 7) 6 "the order of 10 modulo 7 is 6")
    (check-equal? (ord 5 3) 2 "the order of 5 modulo 3 is 2")
    (check-equal? (ord 13 7) 2 "the order of 13 modulo 7 is 2")

    (check-false (prime? 1) "1 is not prime")
    (check-true (prime? 2) "2 is prime")
    (check-false (prime? 4) "4 is not prime")
    (check-true (prime? 71) "71 is prime")

    (check-equal? (prime-factors 1) (set) "1 has no prime factors")
    (check-equal? (prime-factors 2) (set 2) "2 has one prime factor")
    (check-equal? (prime-factors 27) (set 3) "27 has one prime factor")
    (check-equal? (prime-factors 103243) (set 7 43)
                  "103243 has two prime factors")

    (check-equal? (sigma 1) 1 "sum of divisors of 1")
    (check-equal? (sigma 2) 3 "sum of divisors of 2")
    (check-equal? (sigma 15) 24 "sum of divisors of 15")
    (check-equal? (sigma 2015) 2688 "sum of divisors of 2015")
    (check-equal? (sigma 1) (σ 1) "σ is exported")

    (check-equal? (sigma* 1) 0 "sum of divisors of 1, excluding itself")
    (check-equal? (sigma* 2) 1 "sum of divisors of 2, excluding itself")
    (check-equal? (sigma* 15) 9 "sum of divisors of 15, excluding itself")
    (check-equal? (sigma* 2015) 673 "sum of divisors of 2015, excluding itself")

    (check-equal? (tau 1) 1 "number of divisors of 1")
    (check-equal? (tau 2) 2 "number of divisors of 2")
    (check-equal? (tau 15) 4 "number of divisors of 15")
    (check-equal? (tau 2015) 8 "number of divisors of 2015")
    (check-equal? (tau 1) (τ 1) "τ is exported")

    (check-equal? (tau* 1) 0 "number of divisors of 1, excluding itself")
    (check-equal? (tau* 2) 1 "number of divisors of 2, excluding itself")
    (check-equal? (tau* 15) 3 "number of divisors of 15, excluding itself")
    (check-equal? (tau* 2015) 7 "number of divisors of 2015, excluding itself")

    (check-equal? (totient 1) 0 "totient of 1")
    (check-equal? (totient 7) 6 "totient of 7")
    (check-equal? (totient 15) 8 "totient of 15")
    (check-equal? (totient 2015) 1440 "totient of 2015")
    (check-equal? (totient 1) (phi 1) "phi is exported")
    (check-equal? (totient 1) (φ 1) "φ is exported")))
