import scala.Math._
import scala.Stream._

val phi = (1.0 + sqrt(5.0)) / 2.0
def fib(n: Int) = floor(pow(phi, n) / pow(5.0, .5) + .5)
val result = from(0, 1).map(fib(_))
                       .filter(_ % 2 == 0)
                       .takeWhile(_ <= 4E6)
                       .reduceLeft(_ + _)
println(result)
