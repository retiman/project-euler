/*
[minhuang@mocha:scala]$ time scala problem-00036.scala 
872187

real    0m5.044s
user    0m1.696s
sys     0m0.188s
*/

def p10(n: Int) = if (n % 10 == 0) false 
                  else n.toString.reverse.toString == n.toString

def p2(n: Int) = if (n % 2 == 0) false 
                 else n.toBinaryString.reverse.toString == n.toBinaryString

val result = (1 to 1E6.toInt).filter(n => p2(n) && p10(n)).reduceLeft(_ + _)
println(result)
