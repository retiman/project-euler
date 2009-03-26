import scala.Math._

val phi = (1.0 + sqrt(5.0)) / 2.0
def fib(n: Int) = floor(pow(phi, n) / pow(5.0, .5) + .5)

var i = 0
var f = 0D
var x = 0D
while (f <= 4E6) {
  f = fib(i)
  i += 1
  if (f % 2 == 0.0)
    x += f
}
println(x)
