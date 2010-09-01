-- time runghc 15.hs
-- 137846528820
-- 0.39user 0.03system 0:00.69elapsed 61%CPU (0avgtext+0avgdata 0maxresident)k
-- 2872inputs+0outputs (3major+6935minor)pagefaults 0swaps

fact n = product [1..n]
main = print result
       where num = fact 40
             denom = (fact 20) * (fact 20)
             result = div num denom
