# Problem 26: Reciprocal Cycles
#
# Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
#
# See https://projecteuler.net/problem=26
from math import gcd
from project_euler.common.order import ord


def run(limit: int) -> int:
    best_n = 0
    best_t = 0

    for n in range(limit - 1, 1, -1):
        if n % 2 == 0 or n % 5 == 0:
            continue

        if gcd(10, n) != 1:
            continue

        t = ord(10, n)
        if t == n - 1:
            return n

        if t > best_t:
            best_t = t
            best_n = n

    return best_n


def test_run():
    assert run(1000) == 983