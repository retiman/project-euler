// JAVA_OPTS="-Xmx1024M" time scala -deprecation 20.scala
// 648
// 0.66user 0.05system 0:02.37elapsed 30%CPU (0avgtext+0avgdata 0maxresident)k
// 8inputs+64outputs (1major+16154minor)pagefaults 0swaps

def fact(n: BigInt): BigInt = {
  def recur(n: BigInt, acc: BigInt): BigInt = if (n == 1) acc
                                              else recur(n - 1, n * acc)
  if (n == 0) 1 else recur(n, 1)
}

val sum = fact(100).toString.map(_.toString.toInt).reduceLeft(_+_)
println(sum)