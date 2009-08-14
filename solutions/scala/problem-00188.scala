import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet
import scala.io.Source
import scala.Math

val primes = Source.fromFile("../../data/primes.txt").getLines.map(_.trim.toLong).toList
val dmap = new HashMap[Long, Set[Long]]()
val omap = new HashMap[Pair[Long, Long], Long]()

def isqrt(n: Long) = Math.floor(Math.sqrt(n)).toLong

def pfactors(n: Long) = primes.takeWhile(_ <= n).filter(n % _ == 0)

def divisors(n: Long): Set[Long] = {
  if (dmap.contains(n))
    return dmap(n)
  var ts = new HashSet[Long]()
  var t = 2L
  while (t <= isqrt(n)) {
    if (n % t == 0) ts += t
    t += 1
  }
  val ds = Set[Long]() ++ ts ++ ts.map(n / _) ++ Set(1L)
  dmap(n) = ds
  ds 
}

def totient(n: Long) = {
  val ps = pfactors(n)
  val xs = ps.map(_ - 1).zip(ps)
  xs.foldLeft(n) { (a, b) => a * b._1 / b._2 }
}

def mexp(b: Long, e: Long)(m: Long) = {
  def recur(a: Long, b: Long, e: Long): Long = if (e <= 0) a else {
    val t = if ((e & 1) == 1) (a * b) % m else a
    recur(t, (b * b) % m, e >> 1)
  }
  recur(1, b, e)
}

def order(a: Long, m: Long): Long = {
  if (omap.contains(a -> m))
    return omap(a -> m)
  val phi = totient(m)
  val ds = divisors(phi)
  ds.foreach { e =>
    if (mexp(a, e)(m) == 1) {
      omap(a -> m) = e
      return e
    }
  }
  omap(a -> m) = phi
  return phi
}

def mtet(b: Long, e: Long)(m: Long): Long = {
  val r = b % m
  (r, e, m) match {
    case (0, _, _) => 0
    case (_, _, 1) => 0
    case (_, 1, _) => r
    case _      => val ord = order(b, m)
                   val t = mtet(b, e - 1)(ord)
                   mexp(b, t)(m)
  }
}

val result = mtet(1777, 1855)(100000000)
println(result)
