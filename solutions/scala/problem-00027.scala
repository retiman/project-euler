/*
[minhuang@mocha:scala]$ time scala problem-00027.scala 
-59231

real    0m6.639s
user    0m3.316s
sys     0m0.112s
*/
import scala.collection.mutable.HashSet
import scala.io.Source

def f(n: Int, a: Int, b: Int) = n*n + a*n + b

def count(ps: HashSet[Int], a: Int, b: Int): Int = {
  (0 until b).takeWhile(ps contains f(_, a, b)).size
}

def primes() = {
  val set = new HashSet[Int]()
  Source.fromFile("../../data/primes.txt")
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

for (bi <- bs;
     ai <- -bmax until bmax;
     ci <- Some(count(ps, ai, bi)))
  if (ci > c) {
    a = ai
    b = bi
    c = ci
  }

println(a*b)
