// JAVA_OPTS="-Xmx1024M" time scala -deprecation 20.scala
// 648
// 0.66user 0.05system 0:02.37elapsed 30%CPU (0avgtext+0avgdata 0maxresident)k
// 8inputs+64outputs (1major+16154minor)pagefaults 0swaps

def fact(n: BigInt): BigInt = (BigInt(2) to n).reduceLeft(_ * _)
val sum = fact(100).toString.map(_.toString.toInt).reduceLeft(_ + _)
println(sum)
