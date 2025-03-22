# Problem 67: Maximum Path Sum II
#
# Find the maximum total from top to bottom of the triangle.
#
# See https://projecteuler.net/problem=67
from pathlib import Path


def create_row(line: str) -> list[int]:
    return [int(s.strip()) for s in line.strip().split(" ")]


def create_triangle():
    input = Path(__file__).parent / "data" / "67.txt"
    lines = input.read_text().strip().splitlines()
    return [create_row(line) for line in lines]


def run():
    triangle = create_triangle()

    # See problem 18 for an explanation of this algorithm.
    for i in range(len(triangle) - 2, -1, -1):
        for j in range(len(triangle[i])):
            triangle[i][j] += max(triangle[i + 1][j], triangle[i + 1][j + 1])

    return triangle[0][0]


def test_run():
    assert run() == 7273
