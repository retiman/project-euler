/*
[minhuang@mocha:scala]$ time scala problem-00123.scala
21035

real  0m2.951s
user  0m1.400s
sys 0m0.112s
*/
import scala.io.Source

val primes = Source.fromFile("../../data/primes.txt")
                   .getLines
                   .map(_.trim.toLong).toList
val limit = 1E10.toLong

def r(p: Long, n: Long): Long = if (n % 2 == 0) 2 else p*n*2

def find(primes: List[Long], n: Int): Int = primes match {
  case p :: ps if r(p, n) < limit => find(primes.tail, n + 1)
  case p :: ps                    => n
  case _                          => assert(false, "Not enough primes!")
                                  0
}

val result = find(primes, 1)
println(result)
