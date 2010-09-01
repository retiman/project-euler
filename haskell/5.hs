-- time runghc 5.hs
-- 232792560
-- 0.29user 0.03system 0:00.32elapsed 100%CPU (0avgtext+0avgdata 0maxresident)k
-- 0inputs+0outputs (0major+6979minor)pagefaults 0swaps

result = foldr1 lcm [1..20]
main = print result
