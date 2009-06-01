{-
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest number that is evenly divisible by all of the numbers from 1 to 20?

[minhuang@mocha:haskell]$ time runghc problem-00005.hs 
232792560

real    0m0.338s
user    0m0.308s
sys     0m0.016s
-}
result = foldr1 lcm [1..20]
main = print result
