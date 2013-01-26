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
