{-
[minhuang@mocha:haskell]$ time runghc problem-00009.hs 
31875000

real    0m0.868s
user    0m0.788s
sys     0m0.064s
-}
triple = head [[a,b,c] | a <- [1..332], 
                         b <- [a..((1000-a) `div` 2)-1], 
                         c <- [1000-a-b],
                         a+b+c == 1000,
                         a^2+b^2 == c^2]
result = product triple
main = print result                        
