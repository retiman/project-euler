import functools
import math
from project_euler.common.prime_factors import prime_factors


@functools.lru_cache(maxsize=None)
def totient(n: int) -> int:
    if n == 1:
        return 0

    ps = prime_factors(n)
    phi = functools.reduce(lambda acc, p: acc * (1 - 1 / p), ps, n)
    return math.floor(phi)
