/*
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 5
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.

NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem, as there are 2^(99) altogether! If you could check one trillion (10^(12)) routes every second it would take over twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)
*/
import scala.io.Source
import scala.Math._

val data = Source.fromFile("../data/triangle.txt")
                 .getLines
                 .toList
                 .map(_.trim.split(" ").map(_.toLong))
                 .toArray
                 
// Starting from the bottom, reduce each row.  For example:
//   1
//  2 3
// 4 5 6              
// Row #2 becomes 7 9 instead of 2 3 because we want 2 + max(4,5) and 3 + max(5, 6)
// Work backwards to the top and the top row will have the largest sum.
for (i <- data.length - 2 to 0 by -1) {
  for (j <- 0 until data(i).length) {
    val left = data(i + 1)(j)
    val right = data(i + 1)(j + 1)
    val bigger = if (left > right) left else right
    data(i)(j) += bigger    
  }
}

println(data(0)(0))
