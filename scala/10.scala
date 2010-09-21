// time scala -deprecation 10.scala
// 142913828922
// 1.51user 0.08system 0:02.37elapsed 67%CPU (0avgtext+0avgdata 0maxresident)k
// 16inputs+64outputs (1major+25271minor)pagefaults 0swaps

def sieve(limit: Int) = {
  var current = 2
  var numbers = (0 to limit).toArray
  numbers(1) = 0
  while (current <= limit) {
    for (i <- 2 * current to limit by current) numbers(i) = 0
    do { current += 1 } while (current <= limit && numbers(current) == 0)
  }
  numbers.filter(_ != 0).toList
}

println(sieve(2000000).map(_.toLong).reduceLeft(_ + _))
