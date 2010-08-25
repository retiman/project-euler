/*
[minhuang@mocha:scala]$ time scala problem-00012.scala 
76576500

real  0m4.634s
user  0m3.588s
sys 0m0.160s
*/
import scala.Math._

def tau(n: Int) = if (n == 1) 1 else 2 * (1 to sqrt(n)).filter(n % _ == 0).length
def find(n: Int, i: Int): Int = if (tau(n) > 500) n else find(n+i, i+1)
val result = find(3, 3)
println(result)
