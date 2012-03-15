# 6857.0
# 0.13user 0.00system 0:00.16elapsed 85%CPU (0avgtext+0avgdata 7280maxresident)k
# 168inputs+0outputs (1major+1924minor)pagefaults 0swaps

from functools import reduce
from math import sqrt, ceil
from itertools import chain

def fermat_factors(n):
  if n % 2 == 0:
    return [2, n/2]
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
    factors = list(filter(lambda e: e != 1, factors))
  else:
    factors = list(chain.from_iterable(map(prime_factors, factors)))
  return factors

print(max(prime_factors(600851475143)))
