// JAVA_OPTS="-Xmx1024M" time scala -deprecation 35.scala
// 55
// 2.48user 0.14system 0:02.72elapsed 96%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+64outputs (1major+50967minor)pagefaults 0swaps

import scala.io.Source

def rotations(n: Long) = {
  def recur(s: String, rs: List[Long]): List[Long] = {
    if (n.toString == s && rs != Nil)
      return n :: rs
    val m = s.tail + s.head
    recur(m, m.toLong :: rs)
  }
  if (n < 10)
    List(n)
  else
    recur(n.toString, Nil)
}

val primes = Set() ++ Source.fromFile("../data/primes.txt")
                            .getLines
                            .map(_.trim.toLong)
                            .takeWhile(_ < 1000000)

println {
  primes.filter { p =>
    val rs = rotations(p)
    rs.count(primes contains _) == rs.length
  }.size
}
