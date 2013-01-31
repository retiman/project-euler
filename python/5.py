from fractions import gcd
from functools import reduce
from core import irange

def lcm(a, b):
    return a * (b / gcd(a, b))

print reduce(lcm, irange(1, 20), 20)
