/*
[minhuang@mocha:scala]$ time scala problem-00016.scala 
1366

real  0m1.362s
user  0m0.228s
sys 0m0.056s
*/
import scala.Math._

val result = BigInt(2).pow(1000)
                      .toString
                      .map(s => BigInt(s.toString))
                      .reduceLeft(_ + _)
println(result)
