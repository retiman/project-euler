layout: page
title: "Problem 69"
permalink: /problem-69/

Here is a <a href="http://projecteuler.net/problem=69">link to problem #69</a>.  Basically this problem serves as a gentle introduction to Euler's totient function.  Just by looking at the definition you can get a hint about how to solve this problem.<br />
<br />
Note that:<br />
<br />
$$\phi(n) = n\prod_{p|n}(1 - \dfrac{1}{p})$$<br />
<br />
...a proof of which can be found on the <a href="http://en.wikipedia.org/wiki/Totient">wikipedia page for the totient function</a>.<br />
<br />
Armed with that, we can consider maximizing this value:<br />
<br />
$$\dfrac{n}{\phi(n)} = \dfrac{1}{\prod_{p|n}(1 - \dfrac{1}{p})}$$<br />
<br />
It is plain to see that to maximize that ratio, we have to minimize the denominator.  This will happen if there are a lot of $$p_{i}$$'s and each of them are very small, so basically we can hunt for this number by taking the product of the first few primes  (a concept known as the <a href="http://en.wikipedia.org/wiki/Primorial">primorial</a>) such that the product is under 1000000.<br />
<br />
As it turns out,<br />
<br />
$$p_{7}\# = 510510 &lt; 1000000$$ and $$p_{8}\# = 9699690 &gt; 1000000$$<br />
<br />
...so the number we want is 510510.
