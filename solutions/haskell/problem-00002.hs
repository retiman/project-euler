{-
[minhuang@mocha:haskell]$ time runghc problem-00002.hs 
4613732

real    0m0.339s
user    0m0.280s
sys     0m0.028s
-}
fibs = 0 : 1 : zipWith (+) fibs (tail fibs)
result = sum [x | x <- takeWhile (<4000000) fibs, even x]
main = print result
