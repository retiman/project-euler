-- time runghc 21.hs
-- 31626
-- 1.24user 0.07system 0:01.41elapsed 93%CPU (0avgtext+0avgdata 0maxresident)k
-- 16inputs+0outputs (1major+7926minor)pagefaults 0swaps

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
