/*
Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.

*/
import scala.collection.mutable.Set
import scala.Math._

implicit def tupleWrapper[A, B](t: Pair[A, B]) = new {
  def a = t._1
  def b = t._2
}

def divisors(n: Int) = {
  val d = (2 to sqrt(n)).filter(n % _ == 0)
  Set() ++ d ++ d.map(n / _) ++ Set(1)
}

def sigma(n: Int) = divisors(n).reduceLeft(_ + _)

val result = (2 to 10000).map(n => (n, sigma(n)))
                         .filter(t => (t.a > t.b && sigma(t.b) == t.a))
                         .map(t => t.a + t.b)
                         .reduceLeft(_ + _)
println(result)
