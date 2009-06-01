/*
[minhuang@mocha:scala]$ time scala problem-00006.scala 
25164150

real  0m1.280s
user  0m0.232s
sys 0m0.044s
*/
val asq = (1 to 100).map(i => i * i).reduceLeft(_ + _)
val b = (1 to 100).reduceLeft(_ + _)
println(b*b - asq)
