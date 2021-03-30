import scala.language.implicitConversions


implicit def int2bigint(n: Int) = BigInt(n)

def fact(n: BigInt): BigInt = (2 to n).reduceLeft(_ * _)

val num = fact(20 + 20)
val denom = fact(20) * fact(20)
val result = (num / denom).toLong

println(result)
assert(result == 137846528820L)
