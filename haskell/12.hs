-- time runghc 12.hs
-- 76576500
-- 52.62user 0.04system 0:55.35elapsed 95%CPU (0avgtext+0avgdata 0maxresident)k
-- 35832inputs+0outputs (201major+7724minor)pagefaults 0swaps

tau :: Int -> Int
tau 1 = 1
tau n = 2 * x
        where sqn = floor . sqrt . fromIntegral $ n
              x = length $ filter (\i -> mod n i == 0) [1..sqn]

find n i | tau n > 500 = n
find n i | otherwise = find (n+i) (i+1)

result = find 3 3
main = print result
