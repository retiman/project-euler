from functools import reduce
from math import gcd

def lcm(a, b):
    return a * (b // gcd(a, b))

result = reduce(lcm, range(1, 21), 20)
print(result)
