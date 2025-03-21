from project_euler.common.divisors import divisors
from project_euler.common.primes import is_prime


memo: dict[int, list[int]] = {}


def prime_factors(n: int) -> list[int]:
    if n in memo:
        return memo[n]

    ds = divisors(n)
    ps = [d for d in ds if d > 1 and is_prime(d)]

    memo[n] = ps
    return ps
