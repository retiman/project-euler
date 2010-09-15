// JAVA_OPTS="-Xmx1024M" time clojure 15.clj
// 1378465288200
// 0.84user 0.04system 0:00.70elapsed 124%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+64outputs (1major+13870minor)pagefaults 0swaps

def fact(n: BigInt): BigInt = (2 to n).reduceLeft(_ * _)

val num = fact(20 + 20)
val denom = fact(20) * fact(20)
println(num / denom)
