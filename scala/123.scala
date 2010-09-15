// time scala -deprecation 123.scala
// 21035
// 1.58user 0.11system 0:02.23elapsed 76%CPU (0avgtext+0avgdata 0maxresident)k
// 2320inputs+64outputs (1major+24700minor)pagefaults 0swaps

import scala.io.Source

val primes = Source.fromFile("../data/primes.txt")
                   .getLines
                   .map(_.trim.toLong).toList

def r(p: Long, n: Long): Long = if (n % 2 == 0) 2 else p * n * 2

def find(primes: List[Long], n: Int): Int = primes match {
  case p :: ps if r(p, n) < 1E10 => find(primes.tail, n + 1)
  case p :: ps                   => n
  case _                         => assert(false, "Not enough primes!")
                                    0
}

println(find(primes, 1))
