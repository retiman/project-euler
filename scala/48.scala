// JAVA_OPTS="-Xmx1024M" time scala -deprecation 48.scala
// 9110846700
// 1.98user 0.12system 0:04.05elapsed 51%CPU (0avgtext+0avgdata 0maxresident)k
// 72inputs+0outputs (0major+13011minor)pagefaults 0swaps

def mexp(b: BigInt, e: BigInt)(m: BigInt) = {
  def recur(a: BigInt, b: BigInt, e: BigInt): BigInt = if (e <= 0) a else {
    val t = if ((e & 1) == 1) (a * b) % m else a
    recur(t, (b * b) % m, e >> 1)
  }
  recur(1, b, e)
}

val n = 1E10.toLong
val result = (1 to 1000).map { b => mexp(b, b)(n) }
                        .reduceLeft { (a, b) => (a + b) % n }
println(result)
