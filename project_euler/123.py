# Problem 123: Prime Square Remainders
#
# Find the least value of n for which the remainder first exceeds 10^10.
#
# See https://projecteuler.net/problem=123
from sympy import primerange


def r(p: int, n: int) -> int:
    if n % 2 == 0:
        return 2

    return 2 * p * n


def run(limit: int) -> int:
    n = 1

    for p in primerange(2, limit):
        if r(p, n) >= limit:
            return n

        n += 1

    raise ValueError("no solution")


def test_run():
    assert run(10**10) == 21035
