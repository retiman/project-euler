from functools import cache
from sympy import isprime
from project_euler.common.divisors import divisors


@cache
def prime_factors(n: int) -> list[int]:
    ds = divisors(n)
    ps = [d for d in ds if d > 1 and isprime(d)]
    return ps
