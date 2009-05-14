/*
n! means n × (n − 1) × ... × 3 × 2 × 1

Find the sum of the digits in the number 100!
*/
import scala.Math._

def fact(n: BigInt): BigInt = {
  def recur(n: BigInt, acc: BigInt): BigInt = if (n == 1) acc else recur(n - 1, n * acc)
  recur(n, 1)
}

val sum = fact(100).toString.map(_.toString.toInt).reduceLeft(_+_)
println(sum)
