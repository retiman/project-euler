// JAVA_OPTS="-Xmx1024M" time scala -deprecation 25.scala
// 4782
// 1.25user 0.06system 0:02.56elapsed 51%CPU (0avgtext+0avgdata 0maxresident)k
// 8inputs+64outputs (1major+20267minor)pagefaults 0swaps

var index: BigInt = 2
var penultimate: BigInt = 1
var ultimate: BigInt = 1
var fib: BigInt = 1
var length = 1
while (length < 1000) {
  index += 1
  fib = ultimate + penultimate
  penultimate = ultimate
  ultimate = fib
  length = fib.toString.length
}
println(index)
