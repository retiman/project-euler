{-
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a^2 + b^2 = c^2

For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.

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
