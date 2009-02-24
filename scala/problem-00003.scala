/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
*/

import scala.Console._
import scala.Math._
import scala.collection.mutable.HashSet

def fermat_factors(n: Double): Pair[Double, Double] = {
  var a = ceil(sqrt(n))
  var b = a * a - n
  var i = 0
  while (sqrt(b) != round(sqrt(b))) {
    i += 1
    a += 1
    b = a * a - n
    if (i > n) return (1.0, n)
  }
  (a - sqrt(b), a + sqrt(b))
}

def fermat_prime_factors(n: Double): HashSet[Double] = {
  val (n1, n2) = fermat_factors(n)
  val s = new HashSet[Double]()
  (n1, n2) match {
    case (1.0, _) => s += n2
    case (_, 1.0) => s += n1
    case _        => { 
      s ++= fermat_prime_factors(n1)
      s ++= fermat_prime_factors(n2)
    }
  }
  s
}

val n = 600851475143.0D
val p = fermat_prime_factors(n).reduceLeft[Double](_ max _)
println(p)
