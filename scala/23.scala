// JAVA_OPTS="-Xmx1024M" time scala -deprecation 23.scala
// 4179871
// 1.80user 0.03system 0:02.39elapsed 76%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+64outputs (1major+21704minor)pagefaults 0swaps

import scala.collection.mutable.Set
import scala.math._

def divisors(n: Int) = {
  val d = (2 to sqrt(n).toInt).filter(n % _ == 0)
  Set() ++ d ++ d.map(n / _) ++ Set(1)
}

def sigma(n: Int) = divisors(n).reduceLeft(_ + _)

val limit = 28123
val abundants = (1 to limit).filter(n => sigma(n) > n).toArray
val numbers = (0 to limit).toArray

for (
  i <- 0 until abundants.length;
  j <- i until abundants.length
) {
  val index = abundants(i) + abundants(j)
  if (index <= limit)
    numbers(index) = 0
}

val result = numbers.reduceLeft(_+_)
println(result)
