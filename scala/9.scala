for (
  a <- 1 to 332;
  b <- a to ((1000 - a) / 2) - 1;
  c =  1000 - a - b
  if (a * a + b * b == c * c)
) println(a * b * c)
