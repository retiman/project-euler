var n: BigInt = 1
var best_n: BigInt = 1
var best_count: BigInt = 1

while (n < 1000000) {
  var i: BigInt = n
  var count: BigInt = 0

  while (i != 1) {
    if (i % 2 == 0) i /= 2
    else            i = i * 3 + 1
    count += 1
  }

  if (count > best_count) {
    best_count = count
    best_n = n
    //println("n=" + best_n + " count=" + best_count)
  }

  n += 1
}

println(best_n)
