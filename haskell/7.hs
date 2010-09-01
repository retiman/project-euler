-- time runghc 7.hs
-- 104743
-- 1.32user 0.04system 0:01.44elapsed 94%CPU (0avgtext+0avgdata 0maxresident)k
-- 152inputs+0outputs (2major+7761minor)pagefaults 0swaps

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
