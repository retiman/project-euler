{-
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
-}
isPalindrome :: Integer -> Bool
isPalindrome x = (show x) == (reverse . show $ x)

result = head [x*y | x <- takeWhile (>0) [999,998..], 
                     y <- takeWhile (>0) [x,x-1..], 
                     isPalindrome (x*y)]
main = print result                     
