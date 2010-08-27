// JAVA_OPTS="-Xmx1024M" time scala -deprecation 6.scala
// 25164150
// 1.18user 0.16system 0:03.32elapsed 40%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+0outputs (0major+11051minor)pagefaults 0swaps

val a = (1 to 100).map(i => i * i).reduceLeft(_ + _)
val b = (1 to 100).reduceLeft(_ + _)
val result = b * b - a
println(result)
