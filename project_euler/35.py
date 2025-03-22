# Problem 35: Circular Primes
#
# A circular prime is a number for which all rotations of its digits are also prime.  For example: 197 → 971 → 719.
#
# How many circular primes are there below one million?
#
# See https://projecteuler.net/problem=35
from project_euler.common.primes import is_prime, primes


def rotate(xs: list[str]) -> list[str]:
    return xs[1:] + [xs[0]]


def rotations(n: int) -> list[int]:
    digits = list(str(n))
    xs: list[int] = []
    for _ in range(len(digits)):
        digits = rotate(digits)
        xs.append(int("".join(digits)))
    return xs


def is_circular_prime(n: int) -> bool:
    return all(is_prime(p) for p in rotations(n))


def run() -> int:
    return sum(1 for p in primes() if is_circular_prime(p))


def test_run():
    assert run() == 55
