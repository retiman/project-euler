// JAVA_OPTS="-Xmx1024M" time scala -deprecation 27.scala
// -59231
// 2.18user 0.10system 0:02.97elapsed 76%CPU (0avgtext+0avgdata 0maxresident)k
// 2168inputs+64outputs (1major+37457minor)pagefaults 0swaps

import scala.collection.mutable.HashSet
import scala.io.Source

def f(n: Int, a: Int, b: Int) = n*n + a*n + b

def count(ps: HashSet[Int], a: Int, b: Int): Int = {
  (0 until b).takeWhile(ps contains f(_, a, b)).size
}

def primes() = {
  val set = new HashSet[Int]()
  Source.fromFile("../data/primes.txt")
        .getLines
        .map(_.trim.toInt)
        .foreach(set += _)
  set
}

val bmax = 1000
val ps   = primes()
val bs   = { val t = ps.filter(_ < bmax); t ++ t.map(-1 * _) }
var a    = 0
var b    = 0
var c    = 0

for (ai <- -bmax until bmax;
     bi <- bs;
     ci =  count(ps, ai, bi)
     if (ci > c)) {
  a = ai
  b = bi
  c = ci
}

println(a*b)
