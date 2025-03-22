# Problem 34: Digit Factorials
#
# Find the sum of all numbers which are equal to the sum of the factorial of their digits.
#
# See https://projecteuler.net/problem=34
from math import factorial, log10


def digit_factorial(n: int) -> int:
    return sum(factorial(int(d)) for d in str(n))


def is_factorion(n: int) -> bool:
    return n == digit_factorial(n)


def max_digits(limit: float) -> int:
    d = 1
    while (d - 1 - log10(d)) < limit:
        d += 1
    return d - 1


def run() -> int:
    limit = sum(log10(i) for i in range(1, 10))
    digits = max_digits(limit)
    max_factorion = factorial(9) * digits

    return sum(n for n in range(3, max_factorion + 1) if is_factorion(n))


def test_run():
    assert run() == 40730
