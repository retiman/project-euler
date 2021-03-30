import Data.Char (digitToInt)
main = print . sum . map digitToInt . show $ 2 ^ 1000
