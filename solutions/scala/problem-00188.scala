/*
[minhuang@mocha:scala]$ time scala problem-00188.scala 
95962097

real    0m3.536s
user    0m1.648s
sys     0m0.088s
*/
import scala.collection.mutable.HashMap
import scala.collection.mutable.HashSet
import scala.io.Source
import scala.Math

val primes = Source.fromFile("../../data/primes.txt").getLines.map(_.trim.toLong).toList

def isqrt(n: Long) = Math.floor(Math.sqrt(n)).toLong

def pfactors(n: Long) = primes.takeWhile(_ <= n).filter(n % _ == 0)

def divisors(n: Long): Set[Long] = {
  var ts = new HashSet[Long]()
  var t = 2L
  while (t <= isqrt(n)) {
    if (n % t == 0) ts += t
    t += 1
  }
  Set[Long]() ++ ts ++ ts.map(n / _) ++ Set(1L)
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
  val phi = totient(m)
  val ds = divisors(phi) + phi
  ds.toList.sort(_ < _).dropWhile(mexp(a, _)(m) != 1).first
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
