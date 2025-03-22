# Problem 70: Totient Permutation
#
# Find the value of n, 1 < n < 10^7, for which φ(n) is a permutation of n and the ratio n/φ(n) produces a minimum.
#
# See https://projecteuler.net/problem=70
import math
from typing import cast
from sympy import primerange


# This is a special totient function that optimizes the computation of totient for a semi-prime whose factors are p
# and q.
#
# For a prime number, the totient is simply (sub1 p).  Because the totient is a multiplicative function,
# totient(p * q) = totient(p) * totient(q).  Therefore, the totient of a semi-prime is simply (p - 1) * (q - 1).
def totient(p: int, q: int) -> int:
    return (p - 1) * (q - 1)


# Checks if two positive integers' digits are permutations of each other.
def is_permutation(m: int, n: int) -> bool:
    return sorted(str(m)) == sorted(str(n))


def semi_prime_pairs(limit: int) -> list[tuple[int, int]]:
    n = 2 * (math.isqrt(limit) + 1)
    ps = list(primerange(2, n))
    pairs: list[tuple[int, int]] = []

    for i in range(len(ps)):
        for j in range(i, len(ps)):
            p = cast(int, ps[i])
            q = cast(int, ps[j])
            pairs.append((p, q))

    return pairs


def run(limit: int) -> int:
    pairs = semi_prime_pairs(limit)
    result = 0
    min_ratio = math.inf

    for p, q in pairs:
        n = p * q
        if n >= limit:
            continue

        phi = totient(p, q)
        if is_permutation(n, phi):
            ratio = n / phi
            if ratio < min_ratio:
                min_ratio = ratio
                result = n

    return result


def test_run():
    assert run(1_000_000) == 8319823
