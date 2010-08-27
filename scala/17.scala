// JAVA_OPTS="-Xmx1024M" time scala -deprecation 17.scala
// 21124
// 0.91user 0.04system 0:02.14elapsed 44%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+64outputs (1major+18261minor)pagefaults 0swaps

val word = Map(
  1 -> "one",
  2 -> "two",
  3 -> "three",
  4 -> "four",
  5 -> "five",
  6 -> "six",
  7 -> "seven",
  8 -> "eight",
  9 -> "nine",
  10 -> "ten",
  11 -> "eleven",
  12 -> "twelve",
  13 -> "thirteen",
  14 -> "fourteen",
  15 -> "fifteen",
  16 -> "sixteen",
  17 -> "seventeen",
  18 -> "eighteen",
  19 -> "nineteen",
  20 -> "twenty",
  30 -> "thirty",
  40 -> "forty",
  50 -> "fifty",
  60 -> "sixty",
  70 -> "seventy",
  80 -> "eighty",
  90 -> "ninety"
  )

def say(n: Int): String = n match {
  case n if n == 1000                => "one thousand"
  case n if n >= 100 && n % 100 != 0 => word(n / 100) + " hundred and " +
                                        say(n % 100)
  case n if n >= 100 && n % 100 == 0 => word(n / 100) + " hundred"
  case n if n >= 20  && n % 10  != 0 => word(n - (n % 10)) + " " + say(n % 10)
  case n if n >= 20  && n % 10  == 0 => word(n - (n % 10))
  case _                             => word(n)
}

val result = (1 to 1000).map(say _ )
                        .map(_.replace(" ", ""))
                        .map(_.length)
                        .reduceLeft(_ + _)
println(result)
