-- time runghc 20.hs
-- 648
-- 0.32user 0.01system 0:00.33elapsed 100%CPU (0avgtext+0avgdata 0maxresident)k
-- 8inputs+0outputs (0major+6789minor)pagefaults 0swaps

import Data.Char (digitToInt)
main = print . sum . map digitToInt . show . product $ [1..100]
