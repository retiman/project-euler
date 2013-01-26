triple = head [[a,b,c] | a <- [1..332],
                         b <- [a..((1000-a) `div` 2)-1],
                         c <- [1000-a-b],
                         a+b+c == 1000,
                         a^2+b^2 == c^2]
result = product triple
main = print result
