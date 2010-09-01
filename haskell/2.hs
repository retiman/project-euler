-- time runghc 2.hs
-- 4613732
-- 0.30user 0.04system 0:00.34elapsed 98%CPU (0avgtext+0avgdata 0maxresident)k
-- 0inputs+0outputs (0major+6838minor)pagefaults 0swaps

fibs = 0 : 1 : zipWith (+) fibs (tail fibs)
result = sum [x | x <- takeWhile (<4000000) fibs, even x]
main = print result
