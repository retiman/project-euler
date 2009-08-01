/*
[minhuang@mocha:scala]$ time scala problem-00027.scala
-59231

real  0m7.200s
user  0m4.888s
sys 0m0.516s
*/
import scala.collection.mutable.HashSet

def f(n: Int, a: Int, b: Int) = n*n + a*n + b

def count(ps: HashSet[Int], a: Int, b: Int): Int = {
  var c = 0
  0 until b foreach { n =>
    val v = f(n, a, b)
    if (ps contains v) c += 1 else return c
  }
  c
}

def sieve(limit: Int) = {
  var current = 2
  var numbers = (0 to limit).toArray
  numbers(1) = 0
  while (current <= limit) {
    for (i <- 2 * current to limit by current) numbers(i) = 0
    do { current += 1 } while (current <= limit && numbers(current) == 0)
  }
  val set = new HashSet[Int]()
  set ++= numbers.filter(_ != 0)
  set
}

val bmax = 1000
val pmax = f(bmax, bmax, bmax)
val ps   = sieve(pmax)
val bs   = { val t = ps.filter(_ < bmax); t ++ t.map(-1 * _) }
var a    = 0
var b    = 0
var c    = 0

bs foreach { bi =>
  -bmax until bmax foreach { ai =>
    val ci = count(ps, ai, bi)
    if (ci > c) {
      a = ai
      b = bi
      c = ci
    }
  }
}

println(a*b)
