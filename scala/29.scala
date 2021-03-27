import scala.math.pow


val ns = for (a <- 2 to 100; b <- 2 to 100) yield pow(a, b)
val result = (Set() ++ ns).size

println(result)
assert(result == 9183)
