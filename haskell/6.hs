result = (sum [1..100])^2 - (sum [x^2 | x <- [1..100]])
main = print result
