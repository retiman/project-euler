// JAVA_OPTS="-Xmx1024M" time scala -deprecation 15.scala
// 137846528820
// 0.69user 0.04system 0:01.41elapsed 52%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+64outputs (1major+15738minor)pagefaults 0swaps

def fact(n: BigInt): BigInt = {
  def recur(n: BigInt, acc: BigInt): BigInt = if (n == 1) acc
                                              else recur(n - 1, n * acc)
  if (n == 0) 1 else recur(n, 1)
}

val num = fact(20 + 20)
val denom = fact(20) * fact(20)
println(num / denom)
