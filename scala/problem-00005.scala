/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest number that is evenly divisible by all of the numbers from 1 to 20?
*/
import scala.Math._

def gcd(a: BigInt, b: BigInt): BigInt = if (b == 0) a else gcd(b, a % b)

def lcm(a: BigInt, b: BigInt) =  a * b / gcd(a, b)

var x: BigInt = 20
(1 to 20).foreach(i => {
  val b: BigInt = i
  x = lcm(x, b)
})

println(x)
