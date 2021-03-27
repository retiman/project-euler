def isPalindrome(n: Int) = n.toString.reverse.toInt == n

val xs = for (
  i <- 999 to 1 by -1;
  j <- i to 1 by -1;
  if (isPalindrome(i * j))
) yield i * j

val result = xs.reduceLeft(_ max _)

println(result)
assert(result == 906609)
