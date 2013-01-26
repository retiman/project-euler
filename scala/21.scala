import scala.math._

def divisors(n: Int) = {
  val d = (2 to sqrt(n).toInt).filter(n % _ == 0)
  Set() ++ d ++ d.map(n / _) ++ Set(1)
}

def sigma(n: Int) = divisors(n).reduceLeft(_ + _)

println {
  (2 to 10000).map(n => (n, sigma(n)))
              .filter(t => (t._1 > t._2 && sigma(t._2) == t._1))
              .map(t => t._1 + t._2)
              .reduceLeft(_ + _)
}
