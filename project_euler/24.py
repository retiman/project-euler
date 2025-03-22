# Problem 24: Lexicographic Permutations
#
# What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
#
# See https://projecteuler.net/problem=24
from itertools import permutations
from typing import cast
from toolz import curried, pipe


def run() -> int:
    result = pipe(
        range(10),
        permutations,
        curried.map(lambda xs: int("".join(map(str, xs)))),
        sorted,
        lambda xs: xs[999_999],
    )

    return cast(int, result)


def test_run():
    assert run() == 2783915460
