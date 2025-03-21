# Problem 10: Summation of Primes
#
# Find the sum of all the primes below two million.
#
# See https://projecteuler.net/problem=10
from project_euler.common.primes import read_primes


def run(limit: int) -> int:
    ps = read_primes()
    return sum(p for p in ps if p < limit)
