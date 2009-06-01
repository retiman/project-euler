/*
[minhuang@mocha:scala]$ time scala problem-00001.scala 
233168

real  0m1.442s
user  0m0.252s
sys 0m0.056s
*/
val sum = (1 until 1000).filter(n => n % 3 == 0 || n % 5 == 0).reduceLeft(_ + _)
println(sum)
