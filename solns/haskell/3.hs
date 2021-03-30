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
