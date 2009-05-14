/*
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:
13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
*/
import scala.collection.mutable.HashMap

val map = HashMap[Int, Long](1 -> 1)
val limit = 1000000

def next(n: Long) = if (n%2 == 0) n/2 else 3*n+1

def length(n: Long) = {
  def accumulate(n: Long, count: Long): Long = if (n == 1) count else accumulate(next(n), count+1)
  accumulate(n, 1)
}

implicit def pairWrapper(a: Pair[Int, Long]) = new {
  def max(b: Pair[Int, Long]) = if (a._2 > b._2) a else b
}

for (n <- limit to 2 by -1 if !(map contains n)) {
  map(n) = length(n)
  def mark(i: Int, count: Long): Unit = if (i <= limit) {
    map(i) = count+1
    mark(2*i, count+1)
  }  
  mark(2*n, map(n))
}

val max = map.reduceLeft(_ max _)._1

println(max)
