from functools import cache
import math
from project_euler.common.divisors import divisors
from project_euler.common.totient import totient


@cache
def ord(b: int, m: int) -> int:
    if math.gcd(b, m) != 1:
        raise ValueError("b and m must be coprime")

    phi = totient(m)
    ds = divisors(phi)

    for d in ds:
        if pow(b, d, m) == 1:
            return d

    raise ValueError("b and m must be coprime")
