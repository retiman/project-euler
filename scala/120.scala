// time scala -deprecation 120.scala
// 333082500
// 0.97user 0.08system 0:01.93elapsed 54%CPU (0avgtext+0avgdata 0maxresident)k
// 8inputs+64outputs (1major+18980minor)pagefaults 0swaps

def f(a: Int) = {
  def g(n: Int) = n match {
    case 1 => 2 * a
    case _ if n % 2 == 0 => 2
    case _ => 2 * n * a
  }
  (1 to (2 * a)).map(g _)
                .map(_ % (a * a))
                .reduceLeft(_ max _)
}

println((3 to 1000).map(f _).reduceLeft(_ + _))
