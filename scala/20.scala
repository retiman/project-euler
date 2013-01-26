def fact(n: BigInt): BigInt = (BigInt(2) to n).reduceLeft(_ * _)
val sum = fact(100).toString.map(_.toString.toInt).reduceLeft(_ + _)
println(sum)
