import scala.collection.mutable.HashMap

val m = new HashMap[Tuple2[Int, Int], Int]()

def p(k: Int, n: Int): Int = (k, n) match {
  case _ if k > n  => 0
  case _ if k == n => 1
  case _           => if (m contains (k, n)) {
                        m.apply (k, n)
                      } else {
                        val v = p(k + 1, n) + p(k, n - k)
                        m += (k, n) -> v
                        v
                      }
}

val result = p(1, 100) - 1

println(result)
assert(result == 190569291)
