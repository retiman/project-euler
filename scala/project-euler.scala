import scala.Math._

implicit def tuple2Wrapper[A, B](t: Pair[A, B]) = new {
  def a = t._1
  def b = t._2
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

def primeFactors(n: Long): Set[Long] = {
  val factors = fermatFactors(n)
  if (factors contains 1)
    factors - 1
  else
    factors.map(f => primeFactors(f)).reduceLeft(_ ++ _)
}

def divisors(n: Int) = {
  val d = (2 to sqrt(n)).filter(n % _ == 0)
  Set() ++ d ++ d.map(n / _) ++ Set(1)
}

def order(a: Int, m: Int) = {
  def recur(b: Int, numbers: List[Int]): Int = numbers match {
    case x :: Nil => x
    case x :: xs if b == 1 => x
    case _ => recur((a * b) % m, numbers.tail)
  }
  recur(a % m, (1 to m - 1).toList)
}

def gcd(a: Long, b: Long): Long = (a, b) match {
  case (0, _) => a
  case (_, 0) => b
  case (_, _) => gcd(b, a % b)
}

def lcm(a: Long, b: Long) = a * (b / gcd(a, b))

def tau(n: Int) = if (n == 1) 1 else 2 * (1 to sqrt(n)).filter(n % _ == 0).length

def sigma(n: Int) = divisors(n).reduceLeft(_ + _)

def relprime(n: Int) = (2 to n - 1).filter(gcd(n, _) == 1)

def totient(n: Int) = relprime(n).length
