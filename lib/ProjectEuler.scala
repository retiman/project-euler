import scala.Math._

object ProjectEuler {
  val PHI = (1.0 + sqrt(5.0)) / 2.0

  def fib(n: Long) = floor(pow(PHI, n) / pow(5.0, .5) + .5)

  def gcd(a: Long, b: Long): Long = (a, b) match {
    case (0, 0) => throw new Exception("a and b cannot both be zero")
    case (0, _) => b
    case (_, 0) => a
    case _      => gcd(b, a % b)
  }

  def lcm(a: Long, b: Long): Long = (a, b) match {
    case (0, _) => 0
    case (_, 0) => 0
    case _      => a * b / gcd(a, b)
  }

  def fermatFactors(n: Long): Set[Long] = {
    if (n % 2 == 0) return Set(2, n / 2) 
    var a = ceil(sqrt(n))
    var b = a * a - n
    var s = sqrt(b)
    while (s != round(s)) {
      a += 1
      b = a * a -n
      s = sqrt(b)
    }
    Set(a - s, a + s).map(_.toLong)
  }
}
