---
title: "Problem 27: Quadratic Primes"
layout: post
mathjax: true
---

# Quadratic Primes

## Problem

Here is [problem 27](https://projecteuler.net/problem=27):

Euler discovered the remarkable quadratic formula:

$$n^2+n+41$$

It turns out that the formula will produce 40 primes for the consecutive integer values $$0 \leq n \leq 39$$. However, when $$n=40$$, $$40^2+40+41 \le 40(40+1)+41$$ is divisible by 41, and certainly when $$n=41$$, $$41^2+41+41$$ is clearly divisible by 41.

The incredible formula $$n^2-79n+1601$$ was discovered, which produces 80 primes for the consecutive values $$0 \leq n \leq 79$$. The product of the coefficients, −79 and 1601, is −126479.

Considering quadratics of the form:

$$n^2+an+b$$

...where $$\lvert a \rvert \le 1000$$ and $$\lvert b \rvert \leq 1000$$ and $$\lvert n \rvert$$ is the modulus/absolute value of $$n$$ (e.g. $$\lvert 11 \rvert = 11$$ and $$\lvert -4 \rvert = 4$$).

Find the product of the coefficients, $$a$$ and $$b$$, for the quadratic expression that produces the maximum number of primes for consecutive values of $$n$$, starting with $$n=0$$.

## Solution

We can brute force a solution by computing consecutive primes for every quadratic in the solution space of values for $$a$$ and $$b$$.  However, we can narrow the search space by looking at a few constraints.

First, notice that if $$f(0)$$ isn't prime, we wouldn't have a very long prime sequence at all, so consider only values of $$b$$ that are prime.

Second, notice that $$f(b)$$ cannot be prime as:

$$f(b) = b^2+ab+b$$

$$f(b) = b(b+a+1)$$

This means that when computing consecutive primes for values of $$n$$, we only need to consider values in the range $$0 \leq n \le b$$.
