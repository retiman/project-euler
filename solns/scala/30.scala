import scala.math.log
import scala.math.pow


def log10(n: Double) = log(n) / log(10)

def digitalSum5(n: Int) = {
  n.toString
   .map(i => pow(i.toString.toInt, 5))
   .reduceLeft(_ + _)
}

val limit = {
  var d = 1
  while (pow(10, d - 1) <= d * pow(9, 5))
    d += 1
  d * pow(9, 5)
}

val result = (10 until limit.toInt)
    .filter(n => n == digitalSum5(n))
    .reduceLeft(_ + _)

println(result)
assert(result == 443839)
