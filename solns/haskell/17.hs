import Data.Maybe (fromMaybe)

m = [(1,  "one"),
     (2,  "two"),
     (3,  "three"),
     (4,  "four"),
     (5,  "five"),
     (6,  "six"),
     (7,  "seven"),
     (8,  "eight"),
     (9,  "nine"),
     (10, "ten"),
     (11, "eleven"),
     (12, "twelve"),
     (13, "thirteen"),
     (14, "fourteen"),
     (15, "fifteen"),
     (16, "sixteen"),
     (17, "seventeen"),
     (18, "eighteen"),
     (19, "nineteen"),
     (20, "twenty"),
     (30, "thirty"),
     (40, "forty"),
     (50, "fifty"),
     (60, "sixty"),
     (70, "seventy"),
     (80, "eighty"),
     (90, "ninety")]

word n = fromMaybe "" (lookup n m)

say :: Int -> String
say n | n == 1000                  = "one thousand"
      | n >= 100 && mod n 100 /= 0 = let a = word (div n 100)
                                         b = say (mod n 100)
                                     in a ++ " hundred and " ++ b
      | n >= 100 && mod n 100 == 0 = let a = word (div n 100)
                                     in a ++ " hundred"
      | n >= 20  && mod n 10  /= 0 = let a = word (n - (mod n 10))
                                         b = say (mod n 10)
                                     in a ++ " " ++ b
      | n >= 20  && mod n 10  == 0 = word (n - (mod n 10))
      | otherwise                  = word n

join' = filter (/= ' ')

result = sum . map (length . join' . say) $ [1..1000]
main = print result
