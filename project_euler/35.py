# Problem 35: Circular Primes
#
# A circular prime is a number for which all rotations of its digits are also prime.  For example: 197 → 971 → 719.
#
# How many circular primes are there below one million?
#
# See https://projecteuler.net/problem=35
from typing import cast
from sympy import isprime, primerange
from toolz import pipe
from toolz.curried import filter, map, reduce


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
    return all(isprime(p) for p in rotations(n))


def run(limit=1_000_000) -> int:
    result = pipe(
        primerange(2, limit),
        map(lambda p: cast(int, p)),
        filter(lambda p: is_circular_prime(p)),
        map(lambda p: 1),
        reduce(lambda a, b: a + b),
    )
    return cast(int, result)


def test_run():
    assert run() == 55
