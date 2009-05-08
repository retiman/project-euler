/*
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.

*/
import scala.Math._

def s(n: Int) = {
  val range = (2 to n / 2)
  if (range.length == 0)
    n
  else
    1 + (2 to n / 2).map(i => if (n % i == 0) i else 0).reduceLeft(_ + _)
}

val x = (2 to 10000).map(i => {
  val a = i
  val b = s(i)
  if (a > b && s(b) == a)
    a + b
  else
   0
}).reduceLeft(_ + _)
println(x)
