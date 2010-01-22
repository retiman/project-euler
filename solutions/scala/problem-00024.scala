/*
[minhuang@mocha:scala]$ time scala problem-00024.scala
2783915460

real  0m1.329s
user  0m0.236s
sys 0m0.048s
*/

val digits = List(0,1,2,3,4,5,6,7,8,9)
val target = 1000000

def fact(n: Int): Int = {
  def recur(n: Int, acc: Int): Int = if (n == 1) acc else recur(n-1, n*acc)
  if (n == 0) 1 else recur(n, 1)
}

def compute(list: List[Int]): List[Int] = {
  def recur(list: List[Int], current: Int): List[Int] = {
    val permutations = fact(list.length - 1)          // Permutations of the remaining digits
    val index = (target - current) / permutations     // Index of a digit to be fixed, in lexicographical order
    val digit = list(index)
    val next = current + index * permutations         // How many permutations seen so far + how many available after fixing a digit
    list.length match {
      case 2 if target - current == 0 => list         // If we reached the target, leave the last 2 digits in ascending order
      case 2 if target - current == 1 => list.reverse // If we are one off the target, flip them so they are in descending order
      case _                          => digit :: recur(list - digit, next)
    }
  }
  recur(list, 1)
}

println(compute(digits).mkString(""))
