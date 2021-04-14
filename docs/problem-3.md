---
title: "Problem 3: Largest prime factor"
layout: post
mathjax: true
---

# Problem
Here is [problem 3](https://projecteuler.net/problem=3):

The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143?

# Solution
[Trial division](https://en.wikipedia.org/wiki/Trial_division) works just fine for this problem, but the following solution in Scala demonstrations [Fermat's factorization method](https://en.wikipedia.org/wiki/Fermat%27s_factorization_method) (note that Fermat's method can be slower than trial division).  It works like this: suppose you want to find factors of some integer $$n$$, and it can be expressed as the difference of two squares:

$$n=a^2-b^2$$

Then $$n$$ can easily be factored [like so](https://en.wikipedia.org/wiki/Difference_of_two_squares):

$$n=(a+b)(a-b)$$

Because [all odd numbers can be written as the difference of two squares](https://math.stackexchange.com/questions/263101/prove-every-odd-integer-is-the-difference-of-two-squares), we can test out values of $$a$$ starting at $$a=\sqrt{n}$$.  If $$a^2-n=b$$ is a perfect square, we can stop.  Otherwise increment $$a$$ by 1 and keep testing.

If we end up with a result that $$n=(a+b)(a-b)=(1)(n)$$, we can conclude that $$n$$ is prime and stop.

# Code
```scala
import scala.math.ceil
import scala.math.sqrt
import scala.math.round


def fermatFactors(n: Long): Set[Long] = {
  if (n % 2 == 0) return Set(2, n / 2)
  var a = ceil(sqrt(n))
  var b = a * a - n
  var s = sqrt(b)
  while (s != round(s)) {
    a += 1
    b = a * a - n
    s = sqrt(b)
  }
  Set(a - s, a + s).map(_.toLong)
}

def primeFactors(n: Long): Set[Long] = {
  val factors = fermatFactors(n)
  if (factors contains 1)
    factors - 1
  else
    factors.map(f => primeFactors(f)).reduceLeft(_ ++ _)
}

val result = primeFactors(600851475143L).reduceLeft(_ max _)

println(result)
assert(result == 6857)
```
