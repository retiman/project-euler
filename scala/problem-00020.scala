/*
n! means n × (n − 1) × ... × 3 × 2 × 1

Find the sum of the digits in the number 100!
*/
import scala.Math._
import java.math.BigInteger

var n: BigInt = 100
var fact: BigInt = 1
while (n > 1) {
  fact *= n
  n -= 1
}
println(fact.toString.map(s => BigInt(s.toString)).reduceLeft[BigInt](_+_))
