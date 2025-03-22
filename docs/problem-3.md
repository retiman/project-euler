---
title: "Problem 3: Largest Prime Factor"
layout: post
mathjax: true
---

# Largest prime factor

## Problem

Here is [problem 3](https://projecteuler.net/problem=3):

The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143?

## Solution

[Trial division](https://en.wikipedia.org/wiki/Trial_division) works just fine for this problem, but the following solution in Scala demonstrations [Fermat's factorization method](https://en.wikipedia.org/wiki/Fermat%27s_factorization_method) (note that Fermat's method can be slower than trial division).  It works like this: suppose you want to find factors of some integer $$n$$, and it can be expressed as the difference of two squares:

$$n=a^2-b^2$$

Then $$n$$ can easily be factored [like so](https://en.wikipedia.org/wiki/Difference_of_two_squares):

$$n=(a+b)(a-b)$$

Because [all odd numbers can be written as the difference of two squares](https://math.stackexchange.com/questions/263101/prove-every-odd-integer-is-the-difference-of-two-squares), we can test out values of $$a$$ starting at $$a=\sqrt{n}$$.  If $$a^2-n=b$$ is a perfect square, we can stop.  Otherwise increment $$a$$ by 1 and keep testing.

If we end up with a result that $$n=(a+b)(a-b)=(1)(n)$$, we can conclude that $$n$$ is prime and stop.

NOTE: the actual solution takes the easy path out and uses `sympy`.

## Code

```python
import math

def fermat_factors(n: int) -> set[int]:
    if n % 2 == 0:
        return {2, n // 2}
    
    a = math.ceil(math.sqrt(n))
    b = a * a - n
    s = math.sqrt(b)
    
    while s != round(s):
        a += 1
        b = a * a - n
        s = math.sqrt(b)
    
    s = int(s)
    return {a - s, a + s}

def prime_factors(n: int) -> set[int]:
    factors = fermat_factors(n)
    if 1 in factors:
        return factors - {1}
    else:
        result: set[int] = set()
        for f in factors:
            result |= prime_factors(f)
        return result

assert max(prime_factors(600851475143)) == 6857
```
