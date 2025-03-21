# Problem 53: Combinatoric Selections.
#
# Computes the number distinct values of (n choose r) for 1 ≤ n ≤ limit that are greater than 1_000_000.
#
# See {@link https://projecteuler.net/problem=53}.
import math


def run(limit: int) -> int:
    count = 0
    for n in range(1, limit + 1):
        for r in range(1, n):
            c = math.comb(n, r)
            if c > 1_000_000:
                count += 1
    return count


def test_run():
    assert run(100) == 4075
