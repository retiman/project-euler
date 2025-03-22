# Problem 12: Highly Divisible Triangular Number
#
# What is the value of the first triangle number to have over five hundred divisors?
#
# See https://projecteuler.net/problem=12
from project_euler.common.divisors import tau


def run(limit=500) -> int:
    n = 0
    i = 1

    while tau(n) <= limit:
        n += i
        i += 1

    return n


def test_run():
    assert run() == 76576500
