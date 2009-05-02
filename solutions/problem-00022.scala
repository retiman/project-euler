import scala.io.Source
import scala.Math._

val scores = Map() ++ (('A' to 'Z').toList zip (1 to 26).toList)

def score(name: String) = name.map(c => scores(c)).reduceLeft(_ + _)

val data = Source.fromFile("../data/names.txt")
                 .getLines
                 .toList
                 .first
                 .replaceAll("\"", "")
                 .split(",")
                 .toList

val x = (data.indices zip data.sort(_ < _)).map(i => {
  (i._1 + 1) * score(i._2)
}).reduceLeft(_ + _)
println(x)
