-- time runghc 6.hs
-- 25164150
-- 0.33user 0.01system 0:00.37elapsed 94%CPU (0avgtext+0avgdata 0maxresident)k
-- 0inputs+0outputs (0major+6838minor)pagefaults 0swaps

result = (sum [1..100])^2 - (sum [x^2 | x <- [1..100]])
main = print result
