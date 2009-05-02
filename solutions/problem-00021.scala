import scala.Math._

def s(n: Int) = {
  val range = (2 to n / 2)
  if (range.length == 0)
    n
  else
    1 + (2 to n / 2).map(i => if (n % i == 0) i else 0).reduceLeft(_ + _)
}

val x = (2 to 10000).map(i => {
  val a = i
  val b = s(i)
  if (a > b && s(b) == a)
    a + b
  else
   0
}).reduceLeft(_ + _)
println(x)
