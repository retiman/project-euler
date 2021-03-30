isPalindrome :: Integer -> Bool
isPalindrome x = (show x) == (reverse . show $ x)

result = head [x*y | x <- takeWhile (>0) [999,998..],
                     y <- takeWhile (>0) [x,x-1..],
                     isPalindrome (x*y)]
main = print result
