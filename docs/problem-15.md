---
title: "Problem 15: Lattice paths"
layout: post
mathjax: true
---

# Problem
Here is [problem 15](https://projecteuler.net/problem=15):

Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.

How many such routes are there through a 20×20 grid?

# Solution
This problem can be viewed as a [multi-permutation](http://en.wikipedia.org/wiki/Multinomial_coefficient) of 20 L's and 20 R's where L means "go left" and R means "go right".  This way, no searching is needed and the solution can be calculated directly as:

$$\frac{(20 + 20)!}{20!20!}$$

Here is a solution in [Racket](https://github.com/retiman/project-euler/blob/main/racket/15.rkt).

```racket
#! /usr/bin/env racket
#lang racket
(require rackunit)


(define (factorial n)
  (define (factorial* i acc)
    (if (= i 0)
      acc
      (factorial* (sub1 i) (* i acc))))
  (factorial* n 1))

(define result
  (let* ((n (factorial (+ 20 20)))
         (d (* (factorial 20) (factorial 20)))
         (r (/ n d)))
    r))

(displayln result)
(check-equal? result 137846528820)
```
