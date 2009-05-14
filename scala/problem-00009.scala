/*
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
a^2 + b^2 = c^2

For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
*/
for (a <- 1 to 332;                  // max value for a
     b <- a to ((1000 - a) / 2) - 1; // max value for b     
     c <- Some(1000 - a - b)         // only value for c
     if (a*a + b*b == c*c))
  println(a*b*c)
