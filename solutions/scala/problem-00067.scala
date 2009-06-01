/*
[minhuang@mocha:scala]$ time scala problem-00067.scala 
7273

real  0m1.417s
user  0m0.468s
sys 0m0.028s
*/

import scala.io.Source
import scala.Math._

val data = Source.fromFile("../../data/problem-00067.txt")
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
