// JAVA_OPTS="-Xmx1024M" time scala -deprecation 22.scala
// 871198282
// 1.60user 0.05system 0:02.28elapsed 72%CPU (0avgtext+0avgdata 0maxresident)k
// 16inputs+64outputs (1major+25024minor)pagefaults 0swaps

import scala.io.Source
import scala.math._

val scores = Map() ++ (('A' to 'Z').toList zip (1 to 26).toList)
val data = Source.fromFile("../data/22.txt")
                 .getLines
                 .toList
                 .head
                 .replaceAll("\"", "")
                 .split(",")
                 .toList

def score(name: String) = name.map(c => scores(c)).reduceLeft(_ + _)
def f(t: Pair[Int, String]) = (t._1 + 1) * score(t._2)

println {
  data.indices zip data.sortWith(_ < _)).map(f _).reduceLeft(_ + _)
}
