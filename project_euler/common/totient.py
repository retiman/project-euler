import functools
import math
from project_euler.common.prime_factors import prime_factors


@functools.lru_cache(maxsize=None)
def totient(n: int) -> int:
    if n == 1:
        return 0

    ps = prime_factors(n)
    phi = n
    for p in ps:
        phi *= 1 - 1 / p

    return math.floor(phi)
