# Problem 188: Hyperexponentiation
#
# Find the last 8 digits of 1777^^1855.
#
# See https://projecteuler.net/problem=188
from project_euler.common.modular_tetration import hpow


def run():
    return hpow(1777, 1855, 10**8)


def test_run():
    assert run() == 95962097