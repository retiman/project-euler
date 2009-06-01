{-
The sum of the squares of the first ten natural numbers is,
1² + 2² + ... + 10² = 385

The square of the sum of the first ten natural numbers is,
(1 + 2 + ... + 10)² = 55² = 3025

Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

[minhuang@mocha:haskell]$ time runghc problem-00006.hs 
25164150

real    0m0.342s
user    0m0.304s
sys     0m0.016s
-}
result = (sum [1..100])^2 - (sum [x^2 | x <- [1..100]])
main = print result
