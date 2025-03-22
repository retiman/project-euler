# Problem 10: Summation of Primes
#
# Find the sum of all the primes below two million.
#
# See https://projecteuler.net/problem=10
from typing import cast
from sympy import primerange
from toolz import pipe
from toolz.curried import filter, map, reduce


def run(limit=2_000_000) -> int:
    result = pipe(
        primerange(2, limit),
        map(lambda p: cast(int, p)),
        filter(lambda p: p < limit),
        reduce(lambda a, b: a + b),
    )
    return cast(int, result)


def test_run():
    assert run() == 142913828922
