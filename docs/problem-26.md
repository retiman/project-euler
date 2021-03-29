---
title: "Problem 26: Reciprocal cycles"
layout: post
mathjax: true
---

# Problem
Here is [problem 26](https://projecteuler.net/problem=26):

A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

$$
\begin{align*}
&\dfrac{1}{2}  = 0.5 \\
&\dfrac{1}{3}  = 0.\overline{3} \\
&\dfrac{1}{4}  = 0.25 \\
&\dfrac{1}{5}  = 0.2 \\
&\dfrac{1}{6}  = 0.1\overline{6} \\
&\dfrac{1}{7}  = 0.\overline{142857} \\
&\dfrac{1}{8}  = 0.125 \\
&\dfrac{1}{9}  = 0.\overline{1} \\
&\dfrac{1}{10} = 0.1 \\
\end{align*}
$$

Where $$0.1\overline{6}$$ means $$0.16666...$$, and has a 1-digit recurring cycle.  It can be seen that $$\dfrac{1}{7}$$ has a 6-digit recurring cycling.

Find the value of $$d \le 1000$$ for which $$\dfrac{1}{d}$$ contains the longest recurring cycle in its decimal fraction part.

# Solution
It is better to search searching for cycles starting from $$d = 999$$ and decrementing because the longest cycle will occur when $$d$$ is largest.  A number $$\dfrac{1}{n}$$ cannot have more than $$n$$ repeating digits in its decimal expansion.  To illustrate this, consider what is happening when you do long division to calculate $$\dfrac{1}{7}$$:

First you divide 1.0 by 7 and find the remainder. Computationally, this is the same as dividing 10 by 7, then multiplying the remainder by 10, dividing by 7 again, and so on. See the sequence of computations for calculating 1/7 below, written in this manner:

$$
\begin{align*}
&(1 * 10) / 7 = \textbf{(1)} * 7 + 3 \\
&(3 * 10) / 7 = \textbf{(4)} * 7 + 2 \\
&(2 * 10) / 7 = \textbf{(2)} * 7 + 6 \\
&(6 * 10) / 7 = \textbf{(8)} * 7 + 4 \\
&(4 * 10) / 7 = \textbf{(5)} * 7 + 5 \\
&(5 * 10) / 7 = \textbf{(7)} * 7 + 1 \\
&(1 * 10) / 7 = \textbf{(1)} * 7 + 3 \\
&(3 * 10) / 7 = \textbf{(4)} * 7 + 2 \\
\end{align*}
$$

In equation (1), the remainder of 3 is multiplied by 10 in equation (2).  In equation (2), the remainder of 2 is multiplied by 10 in equation (3), and so on.  The bolded numbers happen to form the decimal expansion of $$\dfrac{1}{7} = \overline{14285714}$$.  If the above process is continued, the bolded digits repeat (and the digits of the decimal expansion of $$\dfrac{1}{7}$$ also repeat).

Further notice that:

$$
\begin{align*}
&1 * 10 \pmod{7} \equiv 10^1 \pmod{7} \\
&3 * 10 \pmod{7} \equiv 10^2 \pmod{7} \\
&2 * 10 \pmod{7} \equiv 10^3 \pmod{7} \\
&6 * 10 \pmod{7} \equiv 10^4 \pmod{7} \\
&4 * 10 \pmod{7} \equiv 10^5 \pmod{7} \\
&5 * 10 \pmod{7} \equiv 10^6 \pmod{7} \\
&1 * 10 \pmod{7} \equiv 10^7 \pmod{7} \\
&3 * 10 \pmod{7} \equiv 10^8 \pmod{7} \\
\end{align*}
$$

As you can see, at the next to last step, the digits start to repeat. In fact, the number of repeating digits is given by $$e = ord_{10}n$$, where $$e$$ is the smallest positive integer such that $$10^e \equiv 1 \pmod{n}$$ (this concept is called the [multiplicative order](https://en.wikipedia.org/wiki/Multiplicative_order). The preceding is not a proof of this fact, but it was enough to start searching for solutions near 999.

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
