{-
[minhuang@mocha:haskell]$ time runghc problem-00016.hs
1366

real  0m0.606s
user  0m0.564s
sys 0m0.040s
-}
import Data.Char (digitToInt)
main = print . sum . map digitToInt . show $ 2 ^ 1000
