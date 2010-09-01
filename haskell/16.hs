-- time runghc 16.hs
-- 1366
-- 0.32user 0.03system 0:00.40elapsed 86%CPU (0avgtext+0avgdata 0maxresident)k
-- 152inputs+0outputs (0major+6838minor)pagefaults 0swaps

import Data.Char (digitToInt)
main = print . sum . map digitToInt . show $ 2 ^ 1000
