from fractions import gcd
from functools import reduce

def lcm(a, b):
    return a * (b / gcd(a, b))

print reduce(lcm, xrange(1, 21), 20)
