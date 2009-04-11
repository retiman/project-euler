import scala.Math._

def divisors(n: Int) = 
  if (n == 1) 1 else 2 * (1 to sqrt(n)).filter(n % _ == 0).length

var n = 3
var i = 3
while (divisors(n) <= 500) {
  n += i
  i += 1
}

println(n)
