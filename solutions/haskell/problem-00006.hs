{-
[minhuang@mocha:haskell]$ time runghc problem-00006.hs 
25164150

real    0m0.342s
user    0m0.304s
sys     0m0.016s
-}
result = (sum [1..100])^2 - (sum [x^2 | x <- [1..100]])
main = print result
