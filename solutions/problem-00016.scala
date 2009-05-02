import scala.Math._

val a: BigInt = 2
val n = a.pow(1000)
println(n.toString.map(s => BigInt(s.toString)).reduceLeft[BigInt](_+_))
