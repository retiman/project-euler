/*
By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 5
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom of the triangle below:

75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23

NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route. However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method! ;o)
*/
import scala.collection.immutable.Map
import scala.Console._
import scala.Math._

class Data {
  val xml = <text>
  75
  95 64
  17 47 82
  18 35 87 10
  20 04 82 47 65
  19 01 23 75 03 34
  88 02 77 73 07 63 67
  99 65 04 28 06 16 70 92
  41 41 26 56 83 40 80 70 33
  41 48 72 33 47 32 37 16 94 29
  53 71 44 65 25 43 91 52 97 51 14
  70 11 33 28 77 73 17 78 39 68 17 57
  91 71 52 38 17 14 91 43 58 50 27 29 48
  63 66 04 68 89 53 67 30 73 16 69 87 40 31
  04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
  </text>;
 val t = xml.descendant(0)
      .toString
      .split("\n")
      .toList
      .map(_.trim.split(" ").filter(_ != "").map(BigInt(_)).toList)
      .filter(_.length > 0)

  var row = 0
  var index = 0
  var sum: BigInt = 0
  var path = List[BigInt]()
  reset

  def bottom = row == t.length - 1
  def peekl = t(row + 1)(index)
  def peekr = t(row + 1)(index + 1)
  def left  = { 
    row += 1
    sum += t(row)(index)
    path = path ::: List(t(row)(index))
    sum
  }
  def right = {
    row += 1
    index += 1
    sum += t(row)(index)
    path = path ::: List(t(row)(index))
    sum
  }
  def reset = {
    row = 0
    index = 0
    sum = t(0)(0)
    path = List[BigInt]()
  }
  def sum_down_left: BigInt = {
    var left_sum: BigInt = 0
    (row + 1 until t.length).foreach(r => {
      left_sum += t(r)(index)
    })
    left_sum
  }
  def sum_down_right: BigInt = {
    var right_sum: BigInt = 0
    var i = 1
    (row + 1 until t.length).foreach(r => {
      right_sum += t(r)(index + i)
      i += 1
    })
    right_sum
  }
} 

val data = new Data
while (!data.bottom) {
  val pl = data.peekl
  val pr = data.peekr

  var sl = data.sum_down_left
  sl = if (sl - pl < 0) 0 else sl - pl
  var sr = data.sum_down_right
  sr = if (sr - pr < 0) 0 else sr - pr

  println("sum_left: " + sl + ", sum_right: " + sr + ", left: " + pl + ", right: " + pr + ", diff_sum: " + (sl - sr).abs + ", diff_peek: " + (pl - pr).abs)

  if (sl > sr) {
    if (pl > pr)
      data.left
    else if ( (sl - sr).abs > (pl - pr).abs )
      data.left
    else
      data.right
  }
  else {
    if (pr > pl)
      data.right
    else if ( (sl - sr).abs > (pl - pr).abs )
      data.right
    else
      data.left
  }
}
println(data.sum)
println(data.path)


// Path choosing ok, but do this:  if you go LRL, check if RLL was a better choice
