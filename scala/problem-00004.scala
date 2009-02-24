/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
*/

import scala.Console._
import scala.Math._

def is_palindrome(n: Int) = n.toString.reverse.toString == n.toString
var best = 0

val n = 999
(n to 1 by -1).foreach(i => {
  (n to 1 by -1).foreach(j => {
    val x = i * j
    if (is_palindrome(x) && x > best)
      best = x
  })
})

println(best)    
