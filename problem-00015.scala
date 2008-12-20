/*
Starting in the top left corner of a 2×2 grid, there are 6 routes (without backtracking) to the bottom right corner.

How many routes are there through a 20×20 grid?
*/

import scala.Console._
import scala.Math._

def fact(n: BigInt): BigInt = {
  assume(n >= 0)
  if (n == 0) return 1
  var i: BigInt = n
  var result: BigInt = 1
  while (i > 0) {
    result *= i
    i -= 1
  }
  result
} 

println(fact(20+20)/(fact(20)*fact(20)))
