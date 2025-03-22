# Problem 24: Lexicographic Permutations
#
# What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
#
# See https://projecteuler.net/problem=24
from itertools import permutations
from operator import itemgetter
from typing import cast
from toolz import curried, pipe


def tuple2int(t: tuple[int, ...]) -> int:
    cs = map(str, t)
    s = "".join(cs)
    return int(s)


def run() -> int:
    result = pipe(
        range(10),
        permutations,
        curried.map(tuple2int),
        sorted,
        # Same thing as lambda xs: xs[999_999]
        itemgetter(999_999),
    )

    return cast(int, result)


def test_run():
    assert run() == 2783915460
