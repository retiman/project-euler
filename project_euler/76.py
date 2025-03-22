# Problem 76: Counting Summations
#
# How many different ways can one hundred be written as a sum of at least two positive integers?
#
# See https://projecteuler.net/problem=76
from functools import cache


@cache
def partition(k: int, n: int) -> int:
    if k > n:
        return 0
    if k == n:
        return 1
    return partition(k + 1, n) + partition(k, n - k)


def run(target=100) -> int:
    return partition(1, target) - 1


def test_run():
    assert run() == 190569291
