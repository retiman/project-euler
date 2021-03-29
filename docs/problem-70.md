---
title: "Problem 70: Totient permutation"
layout: post
mathjax: true
---

# Problem
Here is [problem 70](https://projecteuler.net/problem=70):

Euler's Totient function, $$\varphi(n)$$ [sometimes called the phi function], is used to determine the number of positive numbers less than or equal to $$n$$ which are relatively prime to $$n$$. For example, as 1, 2, 4, 5, 7, and 8, are all less than nine and relatively prime to nine, $$\varphi(9)=6$$.

The number 1 is considered to be relatively prime to every positive number, so $$\varphi(1)=1$$.

Interestingly, $$\varphi(87109)=79180$$, and it can be seen that 87109 is a permutation of 79180.

Find the value of $$n$$, $$1 \le n \le 10^{7}$$, for which $$\varphi(n)$$ is a permutation of $$n$$ and the ratio $$\frac{n}{\varphi(n)}$$ produces a minimum.

# Solution
In order for the ratio $$\frac{n}{\varphi(n)}$$ to be at a minimum, $$\varphi(n)$$ needs to be at as large as possible.  Because $$\varphi(n)$$ is the number of positive integers relatively prime (or [coprime](https://en.wikipedia.org/wiki/Coprime_integers)), $$\varphi(n)$$ is at a maximum when $$n$$ is a prime.

This is because a prime number $$p$$ cannot have any other divisors except itself, so every positive integer less than $$p$$ is coprime to it, and hence $$\varphi(p)=p-1$$.

Knowing this, one could generate primes up to $$10^{7}$$, compute the ratio $$\frac{n}{\varphi(n)}$$, and check the permutation constraint.  If there is no permutation, check the next prime less than that, and so on.  However, this approach doesn't work because of the exact fact that $$\varphi(p) = p-1$$; $$\varphi(p)$$ and $$p-1$$ must necessarily differ by at least one digit, and the two values would never be digit permutations of each other.

The next best way to maximize $$\varphi(n)$$ is to consider $$n$$'s that are [semi-primes](https://en.wikipedia.org/wiki/Semiprime) (that is, numbers that are the product of exactly two primes).  In this case, $$n$$ would have a smaller totient than if it were prime, but still there would be more coprime numbers less than $$n$$ than if $$n$$ were, say, composed of the product of 3 or more primes.

The following Racket code generates semi-prime pairs where the factors $$p$$ and $$q$$ are around the vicinity of $$\sqrt{10^{7}}$$ as we want $$n = p \cdot q$$.

```racket
#!/usr/bin/env racket
#lang racket
(require rackunit)
(require srfi/1)
(require srfi/26)


; Search around the radius of (sqrt 1e7), and generate all possible semi-prime
; pairs "around" that vicinity.
(define limit (inexact->exact 1e7))

(define limit* (* 2 (add1 (integer-sqrt limit))))

(define ps 
  (filter (curryr < limit*) (file->list "../data/primes.txt")))

(define bs
  (combinations ps 2))

; This is a special totient function that optimizes the computation of totient
; for a semi-prime whose factors are p and q.
;
; For a prime number, the totient is simply (sub1 p).  Because the totient is
; a multiplicative function, (phi (* p q)) is the same as (* (phi p) (phi q)).
(define (totient* p q)
  (* (sub1 p) (sub1 q)))

; Converts a (base 10) number to a list.  Example: 1234 -> '(1 2 3 4).
(define (number->list n)
  (unfold-right zero? (cut remainder <> 10) (cut quotient <> 10) n))

; Checks if two positive integers' digits are permutations of each other.
(define (digits-permutation? m n)
  (let ((m* (sort (number->list m) <))
        (n* (sort (number->list n) <)))
    (equal? m* n*)))

(define (digits-permutation*? pair)
  (let* ((m (car pair))
         (n (cdr pair)))
    (digits-permutation? m n)))

; Defines pair of totient(n) and the prime factors of n (p and q).
(define (make-totient-to-semi-prime-pair factors)
  (let* ((p (car factors))
         (q (cadr factors))
         (n (* p q)))
    (cons (totient* p q) n)))

; Filter out semiprimes > limit that aren't digit permutations with the totient.
(define (within-limit? pair)
  (let ((n (cdr pair)))
    (<= n limit)))

(define totient-to-semi-prime-pairs
  ((compose (curry filter digits-permutation*?)
            (curry filter within-limit?)
            (curry map make-totient-to-semi-prime-pair))
    bs))

; Of the candidates that are digit permutations and where the ratio is at the
; max, find the largest value of phi(n) * n.
(define min-ratio limit)
(define result 0)

(for ((pair totient-to-semi-prime-pairs))
  (let* ((phi (car pair))
         (n (cdr pair))
         (ratio (/ n phi)))
    (when (< ratio min-ratio)
      (set! min-ratio ratio)
      (set! result n))))

(displayln result)
(check-equal? result 8319823)
```
