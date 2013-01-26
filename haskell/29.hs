import Data.List (nub)

result = length (nub [a^b | a <- [2..100], b <- [2..100]])
main = print result
