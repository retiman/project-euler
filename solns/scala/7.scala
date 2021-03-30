import scala.language.implicitConversions
import scala.language.reflectiveCalls
import scala.language.postfixOps
import scala.math.sqrt
import scala.Stream.from

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

val result = primes.head

println(result)
assert(result == 104743)
