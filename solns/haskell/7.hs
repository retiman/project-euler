merge :: (Ord a) => [a] -> [a] -> [a]
merge xs@(x:xt) ys@(y:yt) = case compare x y of
    LT -> x : (merge xt ys)
    EQ -> x : (merge xt yt)
    GT -> y : (merge xs yt)

remove :: (Ord a) => [a] -> [a] -> [a]
remove xs@(x:xt) ys@(y:yt) = case compare x y of
    LT -> x : (remove xt ys)
    EQ -> remove xt yt
    GT -> remove xs yt

primes, composites :: [Integer]
primes = [2,3,5] ++ (remove [7,9..] composites)
composites = foldr1 f . map g . tail $ primes
    where f (x:xs) ys = x : (merge xs ys)
          g p = [n*p | n <- [p,p+2..]]

result = last . take 10001 $ primes
main = print result
