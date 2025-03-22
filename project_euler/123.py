# Problem 123: Prime Square Remainders
#
# Find the least value of n for which the remainder first exceeds 10^10.
#
# See https://projecteuler.net/problem=123
from typing import cast
from sympy import primerange


def r(p: int, n: int) -> int:
    if n % 2 == 0:
        return 2

    return 2 * p * n


def run(limit=10**10) -> int:
    n = 1

    for x in primerange(2, limit):
        p = cast(int, x)
        if r(p, n) >= limit:
            return n

        n += 1

    raise ValueError("no solution")


def test_run():
    assert run() == 21035
