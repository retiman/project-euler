import scala.Math._

var n: BigInt = 2
var i = 1
while (i <= 10001) {
  if (n.isProbablePrime(20)) 
    i += 1
  n += 1
}
println(n - 1)
