import scala.math.ceil
import scala.math.sqrt
import scala.math.round


def fermatFactors(n: Long): Set[Long] = {
  if (n % 2 == 0) return Set(2, n / 2)
  var a = ceil(sqrt(n))
  var b = a * a - n
  var s = sqrt(b)
  while (s != round(s)) {
    a += 1
    b = a * a - n
    s = sqrt(b)
  }
  Set(a - s, a + s).map(_.toLong)
}

def primeFactors(n: Long): Set[Long] = {
  val factors = fermatFactors(n)
  if (factors contains 1)
    factors - 1
  else
    factors.map(f => primeFactors(f)).reduceLeft(_ ++ _)
}

val result = primeFactors(600851475143L).reduceLeft(_ max _)

println(result)
assert(result == 6857)
