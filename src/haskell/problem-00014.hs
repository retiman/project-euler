{-
[minhuang@mocha:haskell]$ time runghc problem-00014.hs
837799

real  10m52.592s
user  10m47.868s
sys 0m0.156s
-}
import Data.List (foldl')

collatz :: Int -> Integer
collatz 1 = 1
collatz n | even n = 1 + collatz (div n 2)
collatz n | otherwise = 1 + collatz (3*n+1)

max' a b | snd a > snd b = a
max' a b | otherwise = b

alist = [(n, collatz n) | n <- [1..1000000]]
best = foldl' max' (0,0) alist

main = print . fst $ best
