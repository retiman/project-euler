# Problem 1: Multiple of 3 and 5.
#
# Computes the sum of all the multiples of 3 or 5 below the given limit.
#
# See https://projecteuler.net/problem=1
def run(limit: int) -> int:
    return sum([n for n in range(limit) if n % 3 == 0 or n % 5 == 0])


assert run(1000) == 233168
