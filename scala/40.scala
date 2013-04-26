import java.lang.StringBuilder

val s = {
  val sb = new StringBuilder()
  def f(i: Int): String = {
    if (sb.length() < 1000000) {
      sb.append(i)
      f(i + 1)
    } else {
      sb.toString
    }
  }
  f(1)
}

def g(product: Int, i: Int): Int = {
  if (i <= 1000000) {
    val c = s(i - 1)
    val j = c.toString.toInt
    g(product * j, i * 10)
  } else {
    product
  }
}

println(g(1, 1))
