/*
[minhuang@mocha:scala]$ time scala problem-00025.scala 4782

real  0m2.627s
user  0m1.948s
sys 0m0.044s
*/
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
