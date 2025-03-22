from functools import cache
from project_euler.common.divisors import divisors
from project_euler.common.primes import is_prime


@cache
def prime_factors(n: int) -> list[int]:
    ds = divisors(n)
    ps = [d for d in ds if d > 1 and is_prime(d)]
    return ps
