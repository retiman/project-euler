import scala.math._

def log10(n: Double) = log(n) / log(10)

val maxDigits = {
  val limit = (1 to 9).map(i => log10(i)).reduceLeft(_ + _)
  var d = 1
  while (d - 1 - log10(d) < limit) d += 1
  d - 1
}

val maxFactorion = maxDigits * (1 to 9).reduceLeft(_ * _)

def fact(n: Int) = n match {
  case 0 => 1
  case n => (1 to n).reduceLeft(_ * _)
}

def isFactorion(n: Int) = {
  n == n.toString
      .map(_.toString.toInt)
      .map(fact _)
      .reduceLeft(_ + _)
}

val result = (3 to maxFactorion)
    .filter(isFactorion _)
    .reduceLeft(_ + _)

println(result)
assert(result == 40730)
