// JAVA_OPTS="-Xmx1024M" time scala -deprecation 36.scala
// 872187
// 2.34user 0.22system 0:04.78elapsed 53%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+0outputs (0major+28072minor)pagefaults 0swaps

def p10(n: Int) = if (n % 10 == 0) false
                  else n.toString.reverse.toString == n.toString

def p2(n: Int) = if (n % 2 == 0) false
                 else n.toBinaryString.reverse.toString == n.toBinaryString

val result = (1 to 1E6.toInt).filter(n => p2(n) && p10(n)).reduceLeft(_ + _)
println(result)
