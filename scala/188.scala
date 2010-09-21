// JAVA_OPTS="-Xmx1024M" time scala -deprecation 188.scala
// 95962097
// 0.67user 0.05system 0:01.83elapsed 39%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+64outputs (1major+15718minor)pagefaults 0swaps

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

println(mtet(1777, 1855)(100000000))
