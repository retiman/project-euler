import scala.io.Source


def f(n: Int, a: Int, b: Int) = (n * n) + (a * n) + b

def count(ps: Set[Int], a: Int, b: Int): Int = {
  (0 until b).takeWhile(ps contains f(_, a, b)).size
}

def primes = Set() ++ Source.fromFile("../data/primes.txt")
    .getLines
    .map(_.trim.toInt)

val ps = primes.filter(_ < 1000)
val m = Map() ++ {
  for (
    a <- -1000 to 1000;
    b <- ps ++ ps.map(-1 * _);
    c =  count(ps, a, b)
  ) yield c -> (a, b)
}
val tuple = m(m.keys.max)
val result = tuple._1 * tuple._2

println(result)
assert(result == -59231)
