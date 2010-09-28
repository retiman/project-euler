// JAVA_OPTS="-Xmx1024M" time scala -deprecation 76.scala
// 190569291
// 0.78user 0.06system 0:01.95elapsed 43%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+64outputs (1major+16618minor)pagefaults 0swaps

import scala.collection.mutable.HashMap

val m = new HashMap[Pair[Int, Int], Int]()

def p(k: Int, n: Int): Int = (k, n) match {
  case _ if k > n  => 0
  case _ if k == n => 1
  case _           => if (m contains (k, n)) {
                        m.apply (k, n)
                      } else {
                        val v = p(k + 1, n) + p(k, n - k)
                        m += (k, n) -> v
                        v
                      }
}

println(p(1, 100) - 1)
