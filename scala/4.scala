def isPalindrome(n: Int) = n.toString.reverse.toInt == n
val xs = for (
  i <- 999 to 1 by -1;
  j <- i to 1 by -1;
  if (isPalindrome(i * j))
) yield i * j

println(xs.reduceLeft(_ max _))
