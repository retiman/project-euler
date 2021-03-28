---
title: "Problem 67: Maximum path sum II"
layout: post
mathjax: true
---

# Problem
Here is [problem 67](https://projecteuler.net/problem=67).

By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

```
   3
  7 4
 2 4 6
8 5 9 3
```

That is, $$3 + 7 + 4 + 9 = 23$$.

Find the maximum total from top to bottom in [triangle.txt](https://github.com/retiman/project-euler/blob/main/data/67.txt) (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.

NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem, as there are $$2^{99}$$ altogether! If you could check one trillion ($$10^{12}$$) routes every second it would take over twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)

# Solution
Rather than brute force all possible paths starting from the top, start from the bottom row.  To illustrate the algorithm, consider a smaller problem:

```
  ?
 2 3
4 5 6
```

Ignore the first element at the top of the triangle.  Consider you are computing all possible paths for this triangle, and you are currently examining the path to take when at element 2 (at the second row of the triangle).  In this case, the third row is the last, and you would always choose to branch right, choosing element 5 as it is greater than 4 (giving a sub-path sum of $$2+5=7$$).

Similarly, if you were at element 3 on the second row, you would always choose the right branch as well, because 6 is greater than 5 (giving a sub-path sum of $$3+6=9$$).  

Once you have determined this, it's no longer necessary to consider the last row of the triangle, because you could reduce the second row to this:

```
 ?
7 9
```

...since from element 2, the largest sum of each sub-path is 7, and from element 3, the largest sum of each sub-path is 9.

You can apply this logic repeatedly to reduce a triangle of $$n$$ rows down to $$n-1$$ rows.

With this algorithm, the running time is only $$O(n)$$ where $$n$$ is the number of rows of the triangle:

```
#! /usr/bin/env racket
#lang racket
(require rackunit)


(define (2dvector-num-rows a) (vector-length a))

(define (2dvector-num-cols a i)
  (let ((v (vector-ref a i)))
    (length (takef (vector->list v) (lambda (e) (not (= e 0)))))))

(define (2dvector-ref a i j)
  (vector-ref (vector-ref a i) j))

(define (2dvector-set! a i j x)
  (vector-set! (vector-ref a i) j x))

(define input (string-trim (file->string "../data/67.txt")))

(define (string->row s)
  (map string->number (regexp-split #px" " s)))

(define data
  ((compose
     list->vector
     (curry map list->vector)
     (curry map string->row)
     (curry map string-trim)
     (curry regexp-split #px"\n"))
  input))

(for* ((i (range (- (2dvector-num-rows data) 2) (sub1 0) -1))
       (j (range 0 (2dvector-num-cols data i))))
  (let* ((current (2dvector-ref data i j))
         (left (2dvector-ref data (add1 i) j))
         (right (2dvector-ref data (add1 i) (add1 j)))
         (bigger (max left right)))
    (2dvector-set! data i j (+ current bigger))))

(define result (2dvector-ref data 0 0))

(displayln result)
(check-equal? result 7273)
```
