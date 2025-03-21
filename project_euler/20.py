# Problem 20: Factorial Digit Sum
#
# Find the sum of the digits in the number 100!
#
# See https://projecteuler.net/problem=20
import math

def run(n: int) -> int:
    return sum(int(c) for c in str(math.factorial(n)))


def test_run():
    assert run(100) == 648