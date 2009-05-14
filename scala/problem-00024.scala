/*
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
*/

val digits = List(0,1,2,3,4,5,6,7,8,9)
val target = 1000000

def fact(n: Int): Int = {
  def recur(n: Int, acc: Int): Int = if (n == 1) acc else recur(n-1, n*acc)
  if (n == 0) 1 else recur(n, 1)
}

// Strategy: Start with lowest possible first digit, and check the number of permutations remaining.  If it is less
// than the target number, increment that digit and check again.  If it's greater, fix the first digit and move on to
// the second, continuing down to the last 2 digits.
def compute(list: List[Int]): List[Int] = {
  def recur(list: List[Int], current: Int): List[Int] = {
    val permutations = fact(list.length - 1)      // Permutations of the remaining digits
    val index = (target - current) / permutations // Index of a digit to be fixed, in lexicographical order
    val digit = list(index)
    val next = current + index * permutations     // How many permutations seen so far + how many available after fixing a digit
    list.length match {
      case 2 if target - current == 0 => list         // If we reached the target, leave the last 2 digits in ascending order
      case 2 if target - current == 1 => list.reverse // If we are one off the target, flip them so they are in descending order
      case _                          => digit :: recur(list - digit, next)
    }
  }
  recur(list, 1)
}
      
println(compute(digits).mkString(""))
