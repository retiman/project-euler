/*
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number whose proper divisors are less than the number is called deficient and a number whose proper divisors exceed the number is called abundant.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
*/
import scala.collection.mutable.Set
import scala.Math._

def s(n: Int) = {
  val d = (2 to sqrt(n)).filter(n % _ == 0)
  val divisors = Set() ++ d ++ d.map(n / _) ++ Set(1)
  divisors.reduceLeft(_ + _)
}

val limit = 28123
val abundants = (1 to limit).filter(n => s(n) > n).toArray
val numbers = (0 to limit).toArray

for (i <- 0 until abundants.length;
     j <- i until abundants.length) {
  val index = abundants(i) + abundants(j)
  if (index <= limit)
    numbers(abundants(i) + abundants(j)) = 0
}

println(numbers.reduceLeft(_+_))
