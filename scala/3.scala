// JAVA_OPTS="-Xmx1024M" time scala -deprecation 3.scala
// 6857
// 1.48user 0.17system 0:04.06elapsed 40%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+0outputs (0major+11382minor)pagefaults 0swaps

import scala.math._

def fermatFactors(n: Long): Set[Long] = {
  if (n % 2 == 0) return Set(2, n / 2)
  var a = ceil(sqrt(n))
  var b = a * a - n
  var s = sqrt(b)
  while (s != round(s)) {
    a += 1
    b = a * a -n
    s = sqrt(b)
  }
  Set(a - s, a + s).map(_.toLong)
}

def primeFactors(n: Long): Set[Long] = {
  val factors = fermatFactors(n)
  if (factors contains 1)
    factors - 1
  else
    factors.map(f => primeFactors(f)).reduceLeft(_ ++ _)
}

println(primeFactors(600851475143L).reduceLeft(_ max _))
