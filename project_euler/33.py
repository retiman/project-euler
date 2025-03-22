# Problem 33: Digit Cancelling Fractions
#
# Find four non-trivial examples of digit cancelling fractions, less than one in value, express them in lowest common
# terms, multiply them, and return the denominator of the product.
#
# See https://projecteuler.net/problem=33
from functools import reduce
from math import gcd


def int2list(n: int) -> list[int]:
    return [int(d) for d in str(n)]


def list2int(ds: list[int]) -> int:
    return int("".join(map(str, ds)))


def denominators(n: int) -> list[int]:
    a, b = int2list(n)
    xs: set[int] = set()

    for i in range(a, 10):
        xs.add(list2int([i, b]))
        xs.add(list2int([b, i]))

    for i in range(a, 10):
        xs.add(list2int([i, a]))
        xs.add(list2int([a, i]))

    return sorted(x for x in xs if x > n)


def cancellable(m: int, n: int) -> bool:
    m_digits = int2list(m)
    n_digits = int2list(n)

    if 0 in m_digits or 0 in n_digits:
        return False

    v = m / n
    a, b = m_digits
    c, d = n_digits

    return (
        (a == c and d != 0 and v == b / d)
        or (a == d and c != 0 and v == b / c)
        or (b == c and d != 0 and v == a / d)
        or (b == d and c != 0 and v == a / c)
    )


def run():
    fracs = []
    for n in range(11, 100):
        for d in denominators(n):
            if cancellable(n, d):
                fracs.append((n, d))

    ns = reduce(lambda a, b: a * b, (n for n, _ in fracs))
    ds = reduce(lambda a, b: a * b, (d for _, d in fracs))
    x = gcd(ns, ds)

    return ds // x


def test_run():
    assert run() == 100
