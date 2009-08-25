/*
[minhuang@mocha:scala]$ time scala problem-00120.scala
333082500

real  0m2.549s
user  0m0.912s
sys 0m0.100s
*/
def f(a: Int) = {
  val limit = 2 * a
  val r = (3 to limit by 2).map(_ * 2 * a)
                           .map(_ % (a * a))
                           .reduceLeft(_ max _)
  r max 2 max (2 * a)
}

val result = (3 to 1000).map(a => f(a)).reduceLeft(_ + _)
println(result)
