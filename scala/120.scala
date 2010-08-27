// time scala -deprecation 120.scala
// 333082500
// 0.97user 0.08system 0:01.93elapsed 54%CPU (0avgtext+0avgdata 0maxresident)k
// 8inputs+64outputs (1major+18980minor)pagefaults 0swaps

def f(a: Int) = {
  val limit = 2 * a
  val r = (3 to limit by 2).map(_ * 2 * a)
                           .map(_ % (a * a))
                           .reduceLeft(_ max _)
  r max 2 max (2 * a)
}

val result = (3 to 1000).map(f _).reduceLeft(_ + _)
println(result)
