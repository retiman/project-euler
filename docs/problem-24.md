---
title: "Problem 24: Lexicographic permutations"
layout: post
mathjax: true
---

# Problem
Here is [problem 24](https://projecteuler.net/problem=24):

A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

> 012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

# Solution
Start with the smallest possible digit (0 in this case), then find the number of permutations of the remaining digits. If this number is less than 1000000, then 0 cannot be the first digit in the 1000000th permutation.

Try 1 instead, and count the number of permutations. Keep going with 2, 3, 4, etc until the number of permutations exceeds 1000000. Suppose that fixing the first digit at $$k$$ results in more than 1000000 permutations; this means the first digit is fixed at $$k-1$$, and the second digit must be examined by this method.

# Code
```scala
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

val result = compute(digits).mkString("").toLong

println(result)
assert(result == 2783915460L)
```

You can also cheat in Racket by asking the standard library to generate permutations for you.

```racket
#!/usr/bin/env racket
#lang racket
(require rackunit)


(define (list->number lst)
  ((compose string->number
            (curry apply string-append)
            (curry map number->string))
   lst))

(define result
  ((compose (curryr vector-ref (sub1 1000000))
            list->vector
            (curryr sort <)
            (curry map list->number)
            permutations)
     (range 10)))

(displayln result)
(check-equal? result 2783915460)
```
