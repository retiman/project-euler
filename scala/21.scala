/*
[minhuang@mocha:scala]$ time scala problem-00021.scala 
31626

real  0m2.558s
user  0m1.068s
sys 0m0.048s
*/
import scala.collection.mutable.Set
import scala.Math._

implicit def tupleWrapper[A, B](t: Pair[A, B]) = new {
  def a = t._1
  def b = t._2
}

def divisors(n: Int) = {
  val d = (2 to sqrt(n)).filter(n % _ == 0)
  Set() ++ d ++ d.map(n / _) ++ Set(1)
}

def sigma(n: Int) = divisors(n).reduceLeft(_ + _)

val result = (2 to 10000).map(n => (n, sigma(n)))
                         .filter(t => (t.a > t.b && sigma(t.b) == t.a))
                         .map(t => t.a + t.b)
                         .reduceLeft(_ + _)
println(result)
