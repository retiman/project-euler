/*
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
*/
import scala.Math._

val a: BigInt = 2
val n = a.pow(1000)
println(n.toString.map(s => BigInt(s.toString)).reduceLeft[BigInt](_+_))
