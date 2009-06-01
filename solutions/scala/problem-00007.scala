/*
[minhuang@mocha:scala]$ time scala problem-00007.scala 
104743

real  0m11.052s
user  0m9.833s
sys 0m0.092s
*/
import scala.Math._
import scala.Stream._

def nextPrime(implicit primes: List[Int]) = {
  implicit def primality(n: Int) = new {
    def isPrime = primes.filter(p => p <= sqrt(n) && n % p == 0) == Nil
    def isComposite = !isPrime
  }
  from(primes.first + 2, 2).dropWhile(_ isComposite).first
}

implicit var primes = 3 :: 2 :: Nil
for (i <- 3 to 10001) 
  primes = nextPrime :: primes
println(primes.first)
