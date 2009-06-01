/*
[minhuang@mocha:scala]$ time scala problem-00014.scala 
837799

real  0m10.598s
user  0m9.441s
sys 0m0.300s
*/
import scala.collection.mutable.HashMap

val map = HashMap[Int, Long](1 -> 1)
val limit = 1000000

def chainLength(n: Long) = {
  def next(n: Long) = if (n%2 == 0) n/2 else 3*n+1
  def recur(n: Long, count: Long): Long = if (n == 1) count else recur(next(n), count+1)
  recur(n, 1)
}

for (n <- 2 to limit if !(map contains n)) {
  map(n) = chainLength(n)
  // Further powers of 2 are already calculated by this calculation
  def mark(i: Int, count: Long): Unit = if (i <= limit) {
    map(i) = count+1
    mark(2*i, count+1)
  }  
  mark(2*n, map(n))
}

implicit def pairWrapper(a: Pair[Int, Long]) = new {
  def max(b: Pair[Int, Long]) = if (a._2 > b._2) a else b
}

val max = map.reduceLeft(_ max _)._1

println(max)
