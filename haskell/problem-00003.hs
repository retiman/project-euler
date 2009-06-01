{-
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?

[minhuang@mocha:haskell]$ time runghc problem-00003.hs 
6857

real    0m0.314s
user    0m0.280s
sys     0m0.032s
-}
import Data.List

f :: Integer -> Integer
f x = x^2+1

factors' :: Integer -> Integer -> Integer -> Integer -> Integer
factors' x y d n | d > 1 = d
factors' x y d n = factors' a b (gcd c n) n
    where a = mod (f x) n
          b = mod (f . f $ y) n
          c = abs (a-b)

factors :: Integer -> [Integer]
factors n = [factor, n `div` factor]
    where factor = factors' 2 2 1 n

primeFactors :: Integer -> [Integer]
primeFactors n = case factors n of
    xs | elem 1 xs -> xs
    xs -> nub . foldr1 (++) . map primeFactors $ xs

result = maximum . primeFactors $ 600851475143
main = print result
