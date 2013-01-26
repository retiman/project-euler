import scala.collection.mutable.HashMap

val limit = 1000000
val map = HashMap(1L -> 1L)

implicit def pairWrapper(a: Pair[Long, Long]) = new {
  def max(b: Pair[Long, Long]) = if (a._2 > b._2) a else b
}

def length(n: Long): Long = n match {
  case _ if map contains n => map(n)
  case _ if n % 2 == 0     => 1 + length(n / 2)
  case _                   => 1 + length(3 * n + 1)
}

def f(n: Long) = {
  if (!map.contains(n))
    map(n) = length(n)
  (n, map(n))
}

println((1 to limit).map(_.toLong).map(f _).reduceLeft(_ max _)._1)
