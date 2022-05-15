tau :: Int -> Int
tau 1 = 1
tau n = 2 * x
        where sqn = floor . sqrt . fromIntegral $ n
              x = length $ filter (\i -> mod n i == 0) [1..sqn]

find n i | tau n > 500 = n
find n i = find (n+i) (i+1)

result = find 3 3
main = print result
