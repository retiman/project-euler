# Problem 28: Number Spiral Diagonals
#
# What is the sum of the numbers on the diagonals in a 1001x1001 spiral formed in the same way?
#
# See https://projecteuler.net/problem=28
import numpy as np


def turn(direction: str) -> str:
    return {"R": "D", "D": "L", "L": "U", "U": "R"}[direction]


def next(position: tuple[int, int], direction: str) -> tuple[int, int]:
    i, j = position

    return {"R": (i + 1, j), "D": (i, j - 1), "L": (i - 1, j), "U": (i, j + 1)}[direction]


def create_spiral(n: int) -> np.ndarray:
    spiral = np.zeros((n, n), dtype=int)

    mid = n // 2
    heading = "U"
    (i, j) = (mid, mid)

    for x in range(1, n * n + 1):
        # NumPy is row-major order; that is spiral[i][j] == spiral[j, i].
        spiral[j, i] = x
        next_heading = turn(heading)
        (ni, nj) = next((i, j), next_heading)

        if 0 <= ni < n and 0 <= nj < n and spiral[nj, ni] == 0:
            heading = next_heading
            (i, j) = (ni, nj)
        else:
            (i, j) = next((i, j), heading)

    return spiral


def run(limit: int) -> int:
    spiral = create_spiral(limit)
    # Compute sum from top left to bottom right.
    main_diag = np.trace(spiral)
    # Compute sum from bop right to bottom left but horizontally flipping the spiral.
    anti_diag = np.trace(np.fliplr(spiral))
    # Center is double counted, so subtract 1.
    return int(main_diag + anti_diag - 1)


def test_run():
    assert run(1001) == 669171001
