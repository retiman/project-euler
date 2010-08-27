// JAVA_OPTS="-Xmx1024M" time scala -deprecation 7.scala
// 104743
// 29.36user 0.12system 0:33.73elapsed 87%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+0outputs (0major+11573minor)pagefaults 0swaps

import scala.Stream._
import scala.math._

def nextPrime(implicit primes: List[Int]) = {
  implicit def primality(n: Int) = new {
    def isPrime = primes.filter(p => p <= sqrt(n) && n % p == 0) == Nil
    def isComposite = !isPrime
  }
  from(primes.head + 2, 2).dropWhile(_ isComposite).head
}

implicit var primes = 3 :: 2 :: Nil
for (i <- 3 to 10001)
  primes = nextPrime :: primes
println(primes.head)
