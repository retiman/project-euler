def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
def lcm(a: Int, b: Int): Int =  a * (b / gcd(a, b))
println { (1 to 20).foldLeft(20)(lcm(_, _)) }
