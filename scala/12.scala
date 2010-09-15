// time scala -deprecation 12.scala
// 76576500
// 1.47user 0.11system 0:02.41elapsed 65%CPU (0avgtext+0avgdata 0maxresident)k
// 8inputs+64outputs (1major+31636minor)pagefaults 0swaps

import scala.math._

def tau(n: Int) = if (n == 1) 1
                  else 2 * (1 to sqrt(n).toInt).filter(n % _ == 0).length

def find(n: Int, i: Int): Int = if (tau(n) > 500) n else find(n + i, i + 1)

println(find(3, 3))
