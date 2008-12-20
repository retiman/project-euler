/*
The sum of the squares of the first ten natural numbers is,
1² + 2² + ... + 10² = 385

The square of the sum of the first ten natural numbers is,
(1 + 2 + ... + 10)² = 55² = 3025

Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/

import scala.Console._
import scala.Math._

var a: BigInt = 0
var b: BigInt = 0

(1 to 100).foreach(i => {
  val x: BigInt = i
  a += x.pow(2)
})

(1 to 100).foreach(i => {
  val x: BigInt = i
  b += x
})
b = b.pow(2)

println(b - a)
