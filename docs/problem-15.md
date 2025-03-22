---
title: "Problem 15: Lattice Paths"
layout: post
mathjax: true
---

# Lattice paths

## Problem

Here is [problem 15](https://projecteuler.net/problem=15):

Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.

How many such routes are there through a 20×20 grid?

## Solution

This problem can be viewed as a [multi-permutation](http://en.wikipedia.org/wiki/Multinomial_coefficient) of 20 L's and 20 R's where L means "go left" and R means "go right".  This way, no searching is needed and the solution can be calculated directly as:

$$\frac{(20 + 20)!}{20!20!}$$

However, because $$\frac{40!}{20! \cdot (40 - 20)!}$$ is just $$\binom{40}{20}$$, it can be calculated directly via `math.comb`.

## Code

```python
import math

assert math.comb(40, 2) ==  137846528820
```
