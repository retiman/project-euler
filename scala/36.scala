def p10(n: Int) = if (n % 10 == 0) false
                  else n.toString.reverse.toString == n.toString

def p2(n: Int) = if (n % 2 == 0) false
                 else n.toBinaryString.reverse.toString == n.toBinaryString

println((1 to 1E6.toInt).filter(n => p2(n) && p10(n)).reduceLeft(_ + _))
