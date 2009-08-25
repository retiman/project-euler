/*
[minhuang@mocha:scala]$ time scala problem-00048.scala 
9110846700

real  0m2.903s
user  0m1.652s
sys 0m0.120s
*/
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
