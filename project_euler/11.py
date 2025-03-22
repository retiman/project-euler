# Problem 11: Largest Product in a Grid
#
# What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in
# the 20x20 grid?
#
# See https://projecteuler.net/problem=11
from pathlib import Path
from typing import cast
from toolz import pipe
from toolz.curried import map


DIRECTIONS = {
    "U": [-1, 0],
    "R": [0, 1],
    "UR": [-1, 1],
    "DR": [1, 1],
}


def create_row(line: str) -> list[int]:
    row = pipe(
        line.split(" "),
        map(str.strip),
        map(int),
        list,
    )
    return cast(list[int], row)


def create_grid() -> list[list[int]]:
    file = Path(__file__).parent / "data" / "11.txt"
    lines = file.read_text().strip().splitlines()
    return [create_row(line) for line in lines]


def product(m: list[list[int]], i: int, j: int, direction: str) -> int:
    (di, dj) = DIRECTIONS[direction]
    p = 1

    # Safely compute the product of the four elements in the matrix starting at position (i, j) and moving in the
    # direction indicated by (di, dj).
    for k in range(4):
        try:
            p *= m[i + k * di][j + k * dj]
        except:
            return 0

    return p


def run():
    m = create_grid()
    rows = len(m)
    cols = len(m[0])
    result = 0

    for i in range(rows):
        for j in range(cols):
            result = max(
                result,
                product(m, i, j, "U"),
                product(m, i, j, "R"),
                product(m, i, j, "UR"),
                product(m, i, j, "DR"),
            )

    return result


def test_run():
    assert run() == 70600674
