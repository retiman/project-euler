/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
*/
import scala.Math._

def isPalindrome(n: Int) = n.toString.reverse.toInt == n
var best = 0

for (i <- 999 to 1 by -1;
     j <- i to 1 by -1;
     x <- Some(i * j)
     if (isPalindrome(x) && x > best))
  best = x
println(best)
