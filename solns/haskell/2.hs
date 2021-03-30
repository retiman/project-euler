fibs = 0 : 1 : zipWith (+) fibs (tail fibs)
result = sum [x | x <- takeWhile (<4000000) fibs, even x]
main = print result
