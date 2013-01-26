import scala.math._

val ns = for (a <- 2 to 100; b <- 2 to 100) yield pow(a, b)
println {
  (Set() ++ ns).size
}
