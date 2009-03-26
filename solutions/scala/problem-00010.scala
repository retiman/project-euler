/*
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
*/
var s: BigInt = 2
var n: BigInt = 3
while (n < BigInt(2000000)) {
  if (n.isProbablePrime(20))
    s += n
  n += 2
}
println(s)
