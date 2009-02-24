/*
If we list all the natural numbers below 10 that are multiples of 3 or 5,
we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
*/

import scala.Console._

val n = 1000
val a = (0 to n - 1 by 3).reduceLeft[Int](_ + _)
val b = (0 to n - 1 by 5).reduceLeft[Int](_ + _)
val c = (0 to n - 1 by 15).reduceLeft[Int](_ + _)
println(a + b - c)
