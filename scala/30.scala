// JAVA_OPTS="-Xmx1024M" time scala -deprecation 30.scala
// 443839
// 2.00user 0.22system 0:03.03elapsed 73%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+64outputs (1major+75368minor)pagefaults 0swaps

import scala.math._

def log10(n: Double) = log(n) / log(10)

def digitalSum5(n: Int) = {
  n.toString
   .map(i => pow(i.toString.toInt, 5))
   .reduceLeft(_ + _)
}

val limit = {
  var d = 1
  while (pow(10, d - 1) <= d * pow(9, 5))
    d += 1
  d * pow(9, 5)
}

println {
  (10 until limit.toInt).filter(n => n == digitalSum5(n)).reduceLeft(_ + _)
}
