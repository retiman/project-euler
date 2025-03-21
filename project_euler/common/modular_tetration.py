import math
from project_euler.common.order import ord
from project_euler.common.totient import totient


def _f(b: int, e: int, m: int) -> int:
    o = ord(b, m)
    t = mtetn(b, e - 1, o)
    return pow(b, t, m)


def _g(b: int, e: int, m: int, d: int) -> int:
    n = m // d
    t = mtetn(b, e, n)
    i = pow(b, totient(n) - 1, n)
    u = (t * i) % n
    return (b * u) % m


def mtetn(b: int, e: int, m: int) -> int:
    if m == 1:
        return 0

    if e == 1:
        return b % m

    d = math.gcd(b, m)
    if d == 1:
        return _f(b, e, m)

    if d == m:
        return 0

    return _g(b, e, m, d)
