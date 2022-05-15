import Data.List (nub)

divisors n = let sqn = floor . sqrt . fromIntegral $ n
                 a = filter (\q -> mod n q == 0) [2..sqn]
                 b = map (div n) a
             in nub ([1] ++ a ++ b)

sigma = sum . divisors

range = [2..10000]
result = let tuples = zip range (map sigma range)
             amicables = filter (\(a,b) -> a > b && a == sigma b) tuples
         in sum $ map (uncurry (+)) amicables

main = print result
