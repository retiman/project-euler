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
