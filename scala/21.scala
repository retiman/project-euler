// JAVA_OPTS="-Xmx1024M" time scala -deprecation 21.scala
// 31626
// 1.41user 0.05system 0:02.86elapsed 51%CPU (0avgtext+0avgdata 0maxresident)k
// 8inputs+64outputs (1major+21854minor)pagefaults 0swaps

import scala.collection.mutable.Set
import scala.math._

implicit def tupleWrapper[A, B](t: Pair[A, B]) = new {
  def a = t._1
  def b = t._2
}

def divisors(n: Int) = {
  val d = (2 to sqrt(n).toInt).filter(n % _ == 0)
  Set() ++ d ++ d.map(n / _) ++ Set(1)
}

def sigma(n: Int) = divisors(n).reduceLeft(_ + _)

val result = (2 to 10000).map(n => (n, sigma(n)))
                         .filter(t => (t.a > t.b && sigma(t.b) == t.a))
                         .map(t => t.a + t.b)
                         .reduceLeft(_ + _)
println(result)
