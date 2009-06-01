{-
[minhuang@mocha:haskell]$ time runghc problem-00001.hs 
233168

real    0m0.305s
user    0m0.268s
sys     0m0.032s
-}
result = sum [x | x <- [1..999], mod x 3 == 0 || mod x 5 == 0]
main = print result
