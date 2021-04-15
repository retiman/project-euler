from itertools import chain
from math import ceil, sqrt


def fermat_factors(n):
    if n % 2 == 0:
        return [2, n / 2]
    a = ceil(sqrt(n))
    b = a * a - n
    s = sqrt(b)
    while s != round(s):
        a += 1
        b = a * a - n
        s = sqrt(b)
    return [a - s, a + s]


def prime_factors(n):
    factors = fermat_factors(n)
    if 1 in factors:
        factors = filter(lambda e: e != 1, factors)
    else:
        factors = chain.from_iterable(map(prime_factors, factors))
    return factors


result = max(prime_factors(600851475143))
result = int(result)

print(result)
assert result == 6857
