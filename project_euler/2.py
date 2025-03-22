# Problem 2: Even Fibonacci Numbers
#
# Find the sum of all the even Fibonacci numbers below 4_000_000.
#
# See https://projecteuler.net/problem=2.
from itertools import takewhile
from typing import cast
from toolz import curried, pipe
from project_euler.common.fibonacci_numbers import fibs


def run(limit: int) -> int:
    result = pipe(
        fibs(),
        lambda xs: takewhile(lambda x: x < limit, xs),
        curried.filter(lambda x: x % 2 == 0),
        curried.reduce(lambda a, b: a + b),
    )
    return cast(int, result)


def test_run():
    assert run(4_000_000) == 4613732
