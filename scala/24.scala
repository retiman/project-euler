// JAVA_OPTS="-Xmx1024M" time scala -deprecation 24.scala
// 2783915460
// 0.70user 0.04system 0:01.60elapsed 46%CPU (0avgtext+0avgdata 0maxresident)k
// 0inputs+64outputs (1major+15970minor)pagefaults 0swaps

val digits = List(0,1,2,3,4,5,6,7,8,9)
val target = 1000000

def fact(n: Int): Int = if (n == 0 || n == 1) 1 else (2 to n).reduceLeft(_ * _)

def compute(list: List[Int]): List[Int] = {
  def recur(list: List[Int], current: Int): List[Int] = {
    // Permutations of the remaining digits
    val permutations = fact(list.length - 1)
    // Index of a digit to be fixed, in lexicographical order
    val index = (target - current) / permutations
    val digit = list(index)
    // How many permutations seen so far + how many available after fixing a
    // digit
    val next = current + index * permutations
    list.length match {
      // If we reached the target, leave the last 2 digits in ascending order
      case 2 if target - current == 0 => list
      // If we are one off the target, flip them so they are in descending order
      case 2 if target - current == 1 => list.reverse
      case _                          => digit ::
                                         recur(list.filterNot(_ == digit), next)
    }
  }
  recur(list, 1)
}

val result = compute(digits).mkString("")
println(result)
