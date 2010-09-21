// JAVA_OPTS="-Xmx1024M" time scala -deprecation 1.scala
// 233168
// 0.64user 0.04system 0:02.33elapsed 29%CPU (0avgtext+0avgdata 0maxresident)k
// 16inputs+64outputs (1major+15903minor)pagefaults 0swaps

println((1 until 1000).filter(n => n % 3 == 0 || n % 5 == 0).reduceLeft(_ + _))
