# Problem 41: Pandigital Prime
#
# What is the largest n-digit pandigital prime that exists?
#
# See https://projecteuler.net/problem=41
from itertools import permutations
from sympy import isprime


def tuple2int(t: tuple[str]) -> int:
    return int("".join(t))


def run():
    max_p = 0

    # 8 and 9 digit pandigital numbers are divisible by 3, so they cannot be prime.
    for permutation in permutations("7654321"):
        p = tuple2int(permutation)
        if isprime(p):
            max_p = max(max_p, p)

    return max_p


def test_run():
    assert run() == 7652413
