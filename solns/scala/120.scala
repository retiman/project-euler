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

val result = (3 to 1000).map(f _).reduceLeft(_ + _)

println(result)
assert(result == 333082500)
