---
title: "Problem 70: Totient Permutation"
layout: post
mathjax: true
---

# Totient Permutation

## Problem

Here is [problem 70](https://projecteuler.net/problem=70):

Euler's Totient function, $$\varphi(n)$$ [sometimes called the phi function], is used to determine the number of positive numbers less than or equal to $$n$$ which are relatively prime to $$n$$. For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively prime to nine, $$\varphi(9)=6$$.

The number 1 is considered to be relatively prime to every positive number, so $$\varphi(1)=1$$.

Interestingly, $$\varphi(87109)=79180$$, and it can be seen that 87109 is a permutation of 79180.

Find the value of $$n$$, $$1 \le n \le 10^{7}$$, for which $$\varphi(n)$$ is a permutation of $$n$$ and the ratio $$\frac{n}{\varphi(n)}$$ produces a minimum.

## Solution

In order for the ratio $$\frac{n}{\varphi(n)}$$ to be at a minimum, $$\varphi(n)$$ needs to be at as large as possible.  Because $$\varphi(n)$$ is the number of positive integers relatively prime (or [coprime](https://en.wikipedia.org/wiki/Coprime_integers)), $$\varphi(n)$$ is at a maximum when $$n$$ is a prime.

This is because a prime number $$p$$ cannot have any other divisors except itself, so every positive integer less than $$p$$ is coprime to it, and hence $$\varphi(p)=p-1$$.

Knowing this, one could generate primes up to $$10^{7}$$, compute the ratio $$\frac{n}{\varphi(n)}$$, and check the permutation constraint.  If there is no permutation, check the next prime less than that, and so on.  However, this approach doesn't work because of the exact fact that $$\varphi(p) = p-1$$; $$\varphi(p)$$ and $$p-1$$ must necessarily differ by at least one digit, and the two values would never be digit permutations of each other.

The next best way to maximize $$\varphi(n)$$ is to consider $$n$$'s that are [semi-primes](https://en.wikipedia.org/wiki/Semiprime) (that is, numbers that are the product of exactly two primes).  In this case, $$n$$ would have a smaller totient than if it were prime, but still there would be more coprime numbers less than $$n$$ than if $$n$$ were, say, composed of the product of 3 or more primes.

The code generates semi-prime pairs where the factors $$p$$ and $$q$$ are around the vicinity of $$\sqrt{10^{7}}$$ as we want $$n = p \cdot q$$.
