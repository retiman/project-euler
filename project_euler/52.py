# Problem 52: Permuted Multiples
#
# Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
#
# See https://projecteuler.net/problem=52
def sort_digits(n: int) -> str:
    return "".join(sorted(str(n)))


def run() -> int:
    n = 1
    while True:
        s = sort_digits(n)
        if all(sort_digits(n * m) == s for m in range(2, 7)):
            return n
        n += 1


def test_run():
    assert run() == 142857
