# Problem 69: Totient Maximum
#
# Find the value of n ≤ 1_000_000 for which n/φ(n) is a maximum.
#
# See https://projecteuler.net/problem=69
from sympy import primerange


def run(limit: int) -> int:
    acc = 1

    for p in primerange(2, limit):
        n = acc * p
        if n > limit:
            return acc
        acc = n

    raise ValueError("no solution")


def test_run():
    assert run(1_000_000) == 510510
