# Problem 7: 10001st Prime
#
# What is the 10001st prime number?
#
# See https://projecteuler.net/problem=7
from sympy import prime


def run(n=10_001) -> int:
    return int(prime(n))


def test_run():
    assert run() == 104743
