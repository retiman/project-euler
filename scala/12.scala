import scala.math._

def tau(n: Int) = if (n == 1) 1
                  else 2 * (1 to sqrt(n).toInt).filter(n % _ == 0).length

def find(n: Int, i: Int): Int = if (tau(n) > 500) n else find(n + i, i + 1)

println(find(3, 3))
