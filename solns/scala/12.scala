import scala.math.sqrt

def tau(n: Int) = if (n == 1) 1
                  else 2 * (1 to sqrt(n).toInt).filter(n % _ == 0).length

def find(n: Int, i: Int): Int = if (tau(n) > 500) n else find(n + i, i + 1)

val result = find(3, 3)

println(result)
assert(result == 76576500)
