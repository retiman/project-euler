/*
[minhuang@mocha:scala]$ time scala problem-00023.scala 
4179871

real  0m3.545s
user  0m2.532s
sys 0m0.144s
*/
import scala.collection.mutable.Set
import scala.Math._

def divisors(n: Int) = {
  val d = (2 to sqrt(n)).filter(n % _ == 0)
  Set() ++ d ++ d.map(n / _) ++ Set(1)
}

def sigma(n: Int) = divisors(n).reduceLeft(_ + _)

val limit = 28123
val abundants = (1 to limit).filter(n => sigma(n) > n).toArray
val numbers = (0 to limit).toArray

for (i <- 0 until abundants.length;
     j <- i until abundants.length) {
  val index = abundants(i) + abundants(j)
  if (index <= limit)
    numbers(index) = 0
}

println(numbers.reduceLeft(_+_))
