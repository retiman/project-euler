# Problem 14: Longest Collatz Sequence
#
# Which starting number, under one million, produces the longest Collatz sequence?
#
# See https://projecteuler.net/problem=14
from functools import cache


@cache
def collatz_len(n: int) -> int:
    if n == 1:
        return 0

    next = n // 2 if n % 2 == 0 else 3 * n + 1
    return 1 + collatz_len(next)


def run(limit: int) -> int:
    max_len = 0
    current_len = 0
    result = 1

    for i in range(1, limit):
        current_len = collatz_len(i)
        if current_len > max_len:
            max_len = current_len
            result = i

    return result


def test_run():
    assert run(1_000_000) == 837799
