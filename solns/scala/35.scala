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
val result = primes.filter { p =>
  val rs = rotations(p)
  rs.count(primes contains _) == rs.length
}.size

println(result)
assert(result == 55)
