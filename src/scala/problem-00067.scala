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

for (i <- data.length - 2 to 0 by -1;
     j <- 0 until data(i).length) {
  val left = data(i + 1)(j)
  val right = data(i + 1)(j + 1)
  data(i)(j) += left max right
}

val result = data(0)(0)
println(result)
