/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10001st prime number?
*/
import scala.Math._

var x: BigInt = 2
var i = 0

while (i < 10001) {
  if (x.isProbablePrime(20))
    i = i + 1
  x = x + 1
}
println(x)
