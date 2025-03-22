# Problem 6: Sum Square Difference
#
# Find the difference between the sum of the square of the first one hundred natural numbers and the square of the sum.
#
# See https://projecteuler.net/problem=6
from typing import cast
from toolz import curried, pipe


def run() -> int:
    a = pipe(
        range(101),
        curried.map(lambda n: n**2),
        curried.reduce(lambda a, b: a + b),
    )
    b = pipe(
        range(101),
        curried.reduce(lambda a, b: a + b),
        lambda n: n**2,
    )

    a = cast(int, a)
    b = cast(int, b)
    return b - a


def test_run():
    assert run() == 25164150
