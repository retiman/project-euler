/*
[minhuang@mocha:scala]$ time scala problem-00014.scala 
837799

real    0m7.191s
user    0m7.280s
sys     0m0.264s
*/
import scala.collection.mutable.HashMap

val map = HashMap[Long, Long](1L -> 1L)
val limit = 1000000

def length(n: Long): Long = n match {
  case 1                   => 1
  case n if map contains n => map(n)
  case n if n%2 == 0       => 1 + length(n/2)
  case _                   => 1 + length(3*n+1)
}

def f(n: Long) = {
  if (!(map contains n)) 
    map(n) = length(n)
  (n, map(n))
}

implicit def pairWrapper(a: Pair[Long, Long]) = new {
  def max(b: Pair[Long, Long]) = if (a._2 > b._2) a else b
}
                  
val result = (1 to limit).map(_.toLong).map(f _).reduceLeft(_ max _)._1
println(result)
