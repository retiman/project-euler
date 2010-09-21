// JAVA_OPTS="-Xmx1024M" time scala -deprecation 4.scala
// 906609
// 2.38user 0.16system 0:03.94elapsed 64%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+0outputs (0major+20751minor)pagefaults 0swaps

def isPalindrome(n: Int) = n.toString.reverse.toInt == n
val xs = for (
  i <- 999 to 1 by -1;
  j <- i to 1 by -1;
  if (isPalindrome(i * j))
) yield i * j

println(xs.reduceLeft(_ max _))
