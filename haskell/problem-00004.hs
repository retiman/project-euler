{-
[minhuang@mocha:haskell]$ time runghc problem-00004.hs
90909

real    0m0.280s
user    0m0.220s
sys     0m0.044s
-}
isPalindrome :: Integer -> Bool
isPalindrome x = (show x) == (reverse . show $ x)

result = head [x*y | x <- takeWhile (>0) [999,998..],
                     y <- takeWhile (>0) [x,x-1..],
                     isPalindrome (x*y)]
main = print result
