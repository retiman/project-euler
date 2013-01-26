val a = (1 to 100).map(i => i * i).reduceLeft(_ + _)
val b = (1 to 100).reduceLeft(_ + _)
println(b * b - a)
