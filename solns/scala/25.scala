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

val result = index

println(result)
assert(result == 4782)
