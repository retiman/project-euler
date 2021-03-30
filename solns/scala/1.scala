val result = (1 until 1000)
    .filter(n => n % 3 == 0 || n % 5 == 0)
    .reduceLeft(_ + _)

println(result)
assert(result == 233168)
