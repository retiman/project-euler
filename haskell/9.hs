-- time runghc 9.hs
-- 31875000
-- 0.78user 0.04system 0:00.85elapsed 96%CPU (0avgtext+0avgdata 0maxresident)k
-- 0inputs+0outputs (0major+6927minor)pagefaults 0swaps

triple = head [[a,b,c] | a <- [1..332],
                         b <- [a..((1000-a) `div` 2)-1],
                         c <- [1000-a-b],
                         a+b+c == 1000,
                         a^2+b^2 == c^2]
result = product triple
main = print result
