/*
[minhuang@mocha:scala]$ time scala problem-00015.scala 
137846528820

real  0m1.180s
user  0m0.236s
sys 0m0.040s
*/
import scala.Math._

def fact(n: BigInt): BigInt = {
  def recur(n: BigInt, acc: BigInt): BigInt = if (n == 1) acc else recur(n - 1, n * acc)
  if (n == 0) 1 else recur(n, 1)
}

// View problem as a multipermutation on 20 L's and 20 R's where L means "go left" and R means "go right"
val num = fact(20+20)
val denom = fact(20) * fact(20)
println(num/denom)
