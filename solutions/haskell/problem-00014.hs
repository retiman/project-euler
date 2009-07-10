{-
Wow.. 5 hours and no solution.  I'm bad at haskell.
-}
import Prelude hiding (lookup)
import Control.Monad
import Data.HashTable
import Data.List (foldl')

collatz :: (HashTable Int Int) -> Int -> IO Int
collatz m n = lookup m n >>= f'
              where f' (Just v) = return v
                    f' Nothing | even n = collatz m (div n 2) >>= return . (+1)
                    f' _ = collatz m (3*n+1) >>= return . (+1)

max' :: (Int, Int) -> (Int, Int) -> (Int, Int)
max' a b | snd a > snd b = a
max' a b | otherwise = b

main = do m <- fromList hashInt [(1, 1)]
          forM_ [1..limit] $ \n -> do v <- collatz m n
                                      insert m n v
          l <- toList m
          let result = foldl' max' (0,0) l
          print result
          where limit = 1000000
