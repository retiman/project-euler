import scala.io.Source

val data = Source.fromFile("../data/67.txt")
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
assert(result == 7273)
