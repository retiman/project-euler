// JAVA_OPTS="-Xmx1024M" time scala -deprecation 9.scala
// 31875000
// 1.46user 0.12system 0:03.12elapsed 50%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+0outputs (0major+11339minor)pagefaults 0swaps

for (
  a <- 1 to 332;
  b <- a to ((1000 - a) / 2) - 1;
  c =  1000 - a - b
  if (a * a + b * b == c * c)
) println(a * b * c)
