/*
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.

*/
import scala.collection.mutable.Set
import scala.Math._

def sigma(n: Int) = {
  val d = (2 to sqrt(n)).filter(n % _ == 0)
  val divisors = Set() ++ d ++ d.map(n / _) ++ Set(1)
  divisors.reduceLeft(_ + _)
}

val result = (2 to 10000).map(i => {
  val a = i
  val b = sigma(i)
  if (a > b && sigma(b) == a)
    a + b
  else
   0
}).reduceLeft(_ + _)
println(result)
