-- time runghc 29.hs
-- 9183
-- 0.97user 0.02system 0:01.04elapsed 96%CPU (0avgtext+0avgdata 0maxresident)k
-- 2040inputs+0outputs (1major+10642minor)pagefaults 0swaps

import Data.List (nub)

result = length (nub [a^b | a <- [2..100], b <- [2..100]])
main = print result
