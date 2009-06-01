/*
[minhuang@mocha:scala]$ time scala problem-00004.scala 
906609

real  0m2.009s
user  0m0.716s
sys 0m0.068s
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
