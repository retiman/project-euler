def mexp(b: BigInt, e: BigInt)(m: BigInt) = {
  def recur(a: BigInt, b: BigInt, e: BigInt): BigInt = if (e <= 0) a else {
    val t = if ((e & 1) == 1) (a * b) % m else a
    recur(t, (b * b) % m, e >> 1)
  }
  recur(1, b, e)
}

val n = 1E10.toLong
println {
  (1 to 1000).map { b => mexp(b, b)(n) }
             .reduceLeft { (a, b) => (a + b) % n }
}
