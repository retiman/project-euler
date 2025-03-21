import functools
import math


@functools.lru_cache(maxsize=None)
def divisors(n: int) -> list[int]:
    ds: set[int] = set()

    # Use trial division to find all divisors of n, up to sqrt(n).  Only check up to sqrt(n) because you can't have a
    # divisors greater than sqrt(n) that isn't paired with a divisor less than sqrt(n).
    limit = int(math.sqrt(n)) + 1
    for i in range(1, limit):
        if n % i == 0:
            ds.add(i)
            ds.add(n // i)

    return sorted(ds)


def sigma(n: int) -> int:
    return sum(divisors(n))


def tau(n: int) -> int:
    return len(divisors(n))
