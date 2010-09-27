// JAVA_OPTS="-Xmx1024M" time scala -deprecation 29.scala
// 9183
// 0.76user 0.10system 0:01.72elapsed 50%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+64outputs (1major+18792minor)pagefaults 0swaps

import scala.math._

val ns = for (a <- 2 to 100; b <- 2 to 100) yield pow(a, b)
println {
  (Set() ++ ns).size
}
