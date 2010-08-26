/*
[minhuang@mocha:scala]$ time scala problem-00020.scala 
648

real  0m1.227s
user  0m0.248s
sys 0m0.064s
*/
import scala.Math._

def fact(n: BigInt): BigInt = {
  def recur(n: BigInt, acc: BigInt): BigInt = if (n == 1) acc else recur(n - 1, n * acc)
  if (n == 0) 1 else recur(n, 1)
}

val sum = fact(100).toString.map(_.toString.toInt).reduceLeft(_+_)
println(sum)
