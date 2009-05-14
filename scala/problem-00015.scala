/*
Starting in the top left corner of a 2×2 grid, there are 6 routes (without backtracking) to the bottom right corner.

How many routes are there through a 20×20 grid?
*/
import scala.Math._

def fact(n: BigInt): BigInt = {
  def recur(n: BigInt, acc: BigInt): BigInt = if (n == 1) acc else recur(n - 1, n * acc)
  recur(n, 1)
}

// View problem as a multipermutation on 20 L's and 20 R's where L means "go left" and R means "go right"
val num = fact(20+20)
val denom = fact(20) * fact(20)
println(num/denom)
