var s: BigInt = 2
var n: BigInt = 3
while (n < BigInt(2000000)) {
  if (n.isProbablePrime(20))
    s += n
  n += 2
}
println(s)
