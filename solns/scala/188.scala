def order(a: Long, m: Long) = {
  def recur(b: Long, n: Long): Long = n match {
    case _ if n == m - 1 => n
    case _ if b == 1     => n
    case _               => recur((a * b) % m, n + 1)
  }
  recur(a % m, 1L)
}

def mexp(b: Long, e: Long)(m: Long) = {
  def recur(a: Long, b: Long, e: Long): Long = if (e <= 0) a else {
    val t = if ((e & 1) == 1) (a * b) % m else a
    recur(t, (b * b) % m, e >> 1)
  }
  recur(1, b, e)
}

def mtet(b: Long, e: Long)(m: Long): Long = {
  (e, m) match {
    case (_, 1) => 0
    case (1, _) => b % m
    case _      => val ord = order(b, m)
                   val t = mtet(b, e - 1)(ord)
                   mexp(b, t)(m)
  }
}

val result = mtet(1777, 1855)(100000000)

println(result)
assert(result == 95962097)
