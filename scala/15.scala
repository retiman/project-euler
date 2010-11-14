// JAVA_OPTS="-Xmx1024M" time scala -deprecation 15.scala
// 137846528820
// 1.93user 0.22system 0:08.88elapsed 24%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+0outputs (0major+11204minor)pagefaults 0swaps

implicit def int2bigint(n: Int) = BigInt(n)
def fact(n: BigInt): BigInt = (2 to n).reduceLeft(_ * _)
val num = fact(20 + 20)
val denom = fact(20) * fact(20)
println(num / denom)
