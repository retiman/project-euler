---
title: "Problem 26: Reciprocal cycles"
layout: post
mathjax: true
---

# Problem
Here is [problem 26](https://projecteuler.net/problem=26):

A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

$$
\begin{align}
\dfrac{1}{2}  = 0.5
\dfrac{1}{3}  = 0.\overline{3}
\dfrac{1}{4}  = 0.25
\dfrac{1}{5}  = 0.2
\dfrac{1}{6}  = 0.1\overline{6}
\dfrac{1}{7}  = 0.\overline{142857}
\dfrac{1}{8}  = 0.125
\dfrac{1}{9}  = 0.\overline{1}
\dfrac{1}{10} = 0.1
\end{align}
$$

Where $$0.1\overline{6}$$ means $$0.16666...$$, and has a 1-digit recurring cycle.  It can be seen that $$\dfrac{1}{7} has a 6-digit recurring cycling.

Find the value of $$d \le 1000$$ for which $$\dfrac{1}{d}$$ contains the longest recurring cycle in its decimal fraction part.

# Solution


# Code
```racket
#!/usr/bin/env racket
#lang racket
(require (only-in rackunit check-equal?))
(require (only-in "lib/number-theory.rkt" divides? ord))


(define numbers
  (filter (lambda (n) (and (not (divides? 2 n)) (not (divides? 5 n))))
          (range 999 1 -1)))

(define (max-period best numbers)
  (if (empty? numbers)
    best
    (let* ((n (first numbers))
           (t (ord 10 n)))
      (cond ((= t (sub1 n)) (cons n t))
            ((> t (cdr best)) (max-period (cons n t) (rest numbers)))
            (else (max-period best (rest numbers)))))))

(define result
  (car (max-period (cons 0 0) numbers)))

(displayln result)
(check-equal? result 983)
```
