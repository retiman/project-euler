import Data.Char (digitToInt)
main = print . sum . map digitToInt . show . product $ [1..100]
