-- time runghc 4.hs
-- 90909
-- 0.26user 0.02system 0:00.31elapsed 91%CPU (0avgtext+0avgdata 0maxresident)k
-- 8inputs+0outputs (0major+6691minor)pagefaults 0swaps

isPalindrome :: Integer -> Bool
isPalindrome x = (show x) == (reverse . show $ x)

result = head [x*y | x <- takeWhile (>0) [999,998..],
                     y <- takeWhile (>0) [x,x-1..],
                     isPalindrome (x*y)]
main = print result
