// JAVA_OPTS="-Xmx1024M" time scala -deprecation 27.scala
// -59231
// 10.47user 0.88system 0:14.85elapsed 76%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+0outputs (0major+82318minor)pagefaults 0swaps

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

println {
  val tuple = m(m.keys.max)
  tuple._1 * tuple._2
}
