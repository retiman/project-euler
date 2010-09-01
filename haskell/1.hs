-- time runghc 1.hs
-- 233168
-- 0.31user 0.02system 0:00.34elapsed 98%CPU (0avgtext+0avgdata 0maxresident)k
-- 0inputs+0outputs (0major+6839minor)pagefaults 0swaps

result = sum [x | x <- [1..999], mod x 3 == 0 || mod x 5 == 0]
main = print result
