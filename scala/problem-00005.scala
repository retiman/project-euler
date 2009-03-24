/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest number that is evenly divisible by all of the numbers from 1 to 20?
*/
implicit def bigint_wrapper(n: Int) = BigInt(n)
def gcd(a: BigInt, b: BigInt): BigInt = if (b == 0) a else gcd(b, a % b)
def lcm(a: BigInt, b: BigInt) =  a * b / gcd(a, b)
val x = (1 to 20).foldLeft(BigInt(20))(lcm(_, _))
println(x)
