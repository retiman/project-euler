# Problem 3: Large Prime Factor
#
# Find the largest prime factor of a 600851475143.
#
# See https://projecteuler.net/problem=3
from project_euler.common.prime_factors import prime_factors


def run(limit: int) -> int:
    return max(prime_factors(limit))


def test_run():
    assert run(600851475143) == 6857
