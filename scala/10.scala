/*
[minhuang@mocha:scala]$ time scala problem-00010.scala 
142913828922

real  0m3.219s
user  0m1.984s
sys 0m0.248s
*/

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

val result = sieve(2000000).map(_.toLong).reduceLeft(_+_)
println(result);
