/*
[minhuang@mocha:scala]$ time scala problem-00022.scala 
871198282

real  0m2.015s
user  0m0.988s
sys 0m0.084s
*/
import scala.io.Source
import scala.Math._

val scores = Map() ++ (('A' to 'Z').toList zip (1 to 26).toList)

def score(name: String) = name.map(c => scores(c)).reduceLeft(_ + _)

val data = Source.fromFile("../../data/22.txt")
                 .getLines
                 .toList
                 .first
                 .replaceAll("\"", "")
                 .split(",")
                 .toList

def f(t: Pair[Int, String]) = (t._1 + 1) * score(t._2)

val result = (data.indices zip data.sort(_ < _)).map(f _).reduceLeft(_ + _)
println(result)
