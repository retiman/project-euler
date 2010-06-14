/*
[minhuang@mocha:scala]$ time scala problem-00026.scala 
983

real  0m1.105s
user  0m0.252s
sys 0m0.048s
*/
import scala.Math._

implicit def tupleWrapper(t: Pair[Int, Int]) = new {
  def n = t._1
  def ord = t._2
}

def order(a: Int, m: Int) = {
  def recur(b: Int, numbers: List[Int]): Int = numbers match {
    case x :: Nil => x
    case x :: xs if b == 1 => x
    case _ => recur((a * b) % m, numbers.tail)
  }
  recur(a % m, (1 to m - 1).toList)
}

val numbers = (999 to 2 by -1).filter(n => n % 2 != 0 && n % 5 != 0).toList
def maxPeriod(best: Pair[Int, Int], numbers: List[Int]): Pair[Int, Int] =
    numbers match {
  case Nil => best
  case _ => {
    val n = numbers.first
    order(10, n) match {
      case ord if ord == n - 1 => (n, ord)
      case ord if ord > best.ord => maxPeriod((n, ord), numbers.tail)
      case _ => maxPeriod(best, numbers.tail)
    }
  }
}

val result = maxPeriod((0, 0), numbers)
println(result.n)
