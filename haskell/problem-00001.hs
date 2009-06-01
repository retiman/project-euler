{-
If we list all the natural numbers below 10 that are multiples of 3 or 5,
we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.

[minhuang@mocha:haskell]$ time runghc problem-00001.hs 
233168

real    0m0.305s
user    0m0.268s
sys     0m0.032s
-}
result = sum [x | x <- [1..999], mod x 3 == 0 || mod x 5 == 0]
main = print result
