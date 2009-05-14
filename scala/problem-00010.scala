/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
*/
def sieve(limit: Int) = {
  var numbers = (2 to limit).toList
  var primes = List[Int]()
  while (numbers != Nil) {
    primes = numbers.first :: primes
    numbers = numbers.filter(_ % numbers.first != 0)
  }
  primes.reverse
}

println(sieve(2000000).reduceLeft(_ + _))
