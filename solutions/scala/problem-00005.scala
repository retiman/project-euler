/*
[minhuang@mocha:scala]$ time scala problem-00005.scala 
232792560

real  0m1.321s
user  0m0.212s
sys 0m0.056s
*/
def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
def lcm(a: Int, b: Int): Int =  a * (b / gcd(a, b))
val result = (1 to 20).foldLeft(20)(lcm(_, _))
println(result)
