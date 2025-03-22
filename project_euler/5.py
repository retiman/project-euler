# Problem 5: Smallest Multiple
#
# Find the smallest positive number that is evenly divisible by all of the numbers from 1 to 20.
#
# See https://projecteuler.net/problem=5
from functools import reduce
from math import lcm


def run(limit=20) -> int:
    return reduce(lcm, range(1, limit + 1))


def test_run():
    assert run() == 232792560
