{-
[minhuang@mocha:haskell]$ time runghc problem-00021.hs 
31626

real  0m2.343s
user  0m2.216s
sys 0m0.056s
-}
import Data.List (nub)

divisors n = let sqn = floor . sqrt . fromIntegral $ n
                 a = filter (\q -> mod n q == 0) [2..sqn]
                 b = map (\q -> div n q) a
             in nub ([1] ++ a ++ b)

sigma n = sum . divisors $ n

range = [2..10000]
result = let tuples = zip range (map sigma range)
             amicables = filter (\(a,b) -> a > b && a == sigma b) tuples
         in sum $ map (\(a,b) -> a+b) amicables

main = print result         
