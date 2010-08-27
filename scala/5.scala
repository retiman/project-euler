// JAVA_OPTS="-Xmx1024M" time scala -deprecation 5.scala
// 232792560
// 1.19user 0.13system 0:02.85elapsed 46%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+0outputs (0major+11119minor)pagefaults 0swaps

def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
def lcm(a: Int, b: Int): Int =  a * (b / gcd(a, b))
val result = (1 to 20).foldLeft(20)(lcm(_, _))
println(result)
