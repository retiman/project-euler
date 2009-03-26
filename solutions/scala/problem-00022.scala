/*
Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
 */
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
