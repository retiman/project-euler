# Problem 7: 10001st Prime
#
# What is the 10001st prime number?
#
# See https://projecteuler.net/problem=7
from project_euler.common.primes import read_primes


def run(n: int) -> int:
    ps = read_primes()
    return ps[n - 1]


def test_run():
    assert run(10001) == 104743
