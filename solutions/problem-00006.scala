val a = (1 to 100).map(BigInt(_)).map(_.pow(2)).reduceLeft(_ + _)
val b = (1 to 100).map(BigInt(_)).reduceLeft(_ + _).pow(2)
println(b - a)
