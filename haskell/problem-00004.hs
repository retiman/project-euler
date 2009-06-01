{-
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.

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
