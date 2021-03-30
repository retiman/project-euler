val a = (1 to 100).map(i => i * i).reduceLeft(_ + _)
val b = (1 to 100).reduceLeft(_ + _)
val result = b * b - a

println(result)
assert(result == 25164150)
