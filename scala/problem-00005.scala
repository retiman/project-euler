/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest number that is evenly divisible by all of the numbers from 1 to 20?
*/
def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
def lcm(a: Int, b: Int): Int =  a * (b / gcd(a, b))
val x = (1 to 20).foldLeft(20)(lcm(_, _))
println(x)
