val result = BigInt(2)
    .pow(1000)
    .toString
    .map(s => BigInt(s.toString))
    .reduceLeft(_ + _)

println(result)
assert(result == 1366)
