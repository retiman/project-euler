// JAVA_OPTS="-Xmx1024M" time scala -deprecation 16.scala
// 1366
// 0.66user 0.06system 0:01.84elapsed 38%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+64outputs (1major+15900minor)pagefaults 0swaps

val result = BigInt(2).pow(1000)
                      .toString
                      .map(s => BigInt(s.toString))
                      .reduceLeft(_ + _)
println(result)
