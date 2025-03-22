# Problem 27: Quadratic Primes
#
# Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes
# for consecutive values of n, starting with n = 0.
#
# Only consider |a| < 1000 and |b| < 1000.
#
# See https://projecteuler.net/problem=27
from project_euler.common.primes import primes_under


def f(n: int, a: int, b: int) -> int:
    return n ** 2 + a * n + b


def count_primes(a: int, b: int, ps: set[int]) -> int:
    n = 0
    while True:
        y = f(n, a, b)
        if y < 2 or y not in ps:
            return n
        n += 1


def run(limit: int):
    candidates: dict[int, tuple[int, int]] = {}
    ps = primes_under(limit).tolist()

    bs = ps + [-p for p in ps]
    for b in bs:
        for a in range(-limit, limit + 1):
            c = count_primes(a, b, ps)
            candidates[c] = (a, b)

    best = max(candidates.keys())
    (a, b) = candidates[best]
    return a * b


def test_run():
    assert run(1000) == -59231