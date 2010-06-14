{-
[minhuang@mocha:haskell]$ time runghc problem-00020.hs
648

real  0m0.624s
user  0m0.552s
sys 0m0.052s
-}
import Data.Char (digitToInt)
main = print . sum . map digitToInt . show . product $ [1..100]
