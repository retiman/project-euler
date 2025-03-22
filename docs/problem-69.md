---
title: "Problem 69: Totient Maximum"
layout: post
mathjax: true
---

# Totient Maximum

## Problem

Here is [problem 69](https://projecteuler.net/problem=69):

Euler's Totient function, $$\varphi(n)$$ [sometimes called the phi function], is used to determine the number of numbers less than $$n$$ which are relatively prime to $$n$$. For example, as 1, 2, 4, 5, 7, and 8, are all less than 9 and relatively prime to 9, $$\varphi(9)=6$$.

|n  |Relatively Prime|$$\varphi(n)$$|$$n/\varphi(n)$$|
|---|----------------|--------------|----------------|
|2  |1,2             |2             |1.5             |
|3  |1,2             |2             |1.5             |
|4  |1,3             |2             |2               |
|5  |1,2,3,4         |4             |1.25            |
|6  |1,5             |2             |3               |
|7  |1,2,3,4,5,6     |6             |1.1666...       |
|8  |1,3,5,7         |4             |2               |
|9  |1,2,4,5,7,8     |6             |1.5             |
|10 |1,3,7,9         |4             |2.5             |

It can be seen that $$n=6$$ produces a maximum $$n/\varphi(n)$$ for $$n \leq 10$$.

Find the value of $$n \leq 1,000,000$$ for which $$n/\varphi(n)$$ is a maximum.

## Solution

From the [wikipedia page on the totient function](https://en.wikipedia.org/wiki/Euler%27s_totient_function):

$$\dfrac{n}{\varphi(n)} = \dfrac{1}{n\prod_{p|n}(1 - \dfrac{1}{p})}$$

In order to maximize the the ratio, we have to minimize the denominator, or this value:

$$\varphi(n) = n\prod_{p|n}(1 - \dfrac{1}{p})$$

This value will be small if we can make sure that $$n$$ has many prime divisors.  This is because $$(1 - \dfrac{1}{p}) \le 1$$, so if we make sure there are lots of $$p_{i}$$'s and each of them are very small, we can multiply $$n$$ by a lot of fractions to make $$n$$ small as well.

Because we know that making $$n$$ the product of consecutive primes will yield maximum values for the ratio of $$n/\varphi(n)$$, we don't actually need to calculate $$\varphi(n)$$ or the ratio itself.  We just need to compute values of $$n$$ that fall within these constraints.

The product of $$m$$ consecutive primes is known as the [primorial](http://en.wikipedia.org/wiki/Primorial), and denoted $$p_{m}\#$$:

$$p_{m}\# = \prod_{k=1}^m p_{k}$$

With a list of primes it can be calculated that $$p_{7}\# = 510510$$ and $$p_{8}\# = 9699690$$, the latter of which is larger than our limit of 1000000, so $$p_{7}\#$$ is the answer.
