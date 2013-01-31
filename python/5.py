from core import irange
from fractions import gcd
from functools import reduce

def lcm(a, b):
    return a * (b / gcd(a, b))

print reduce(lcm, irange(1, 20), 20)
