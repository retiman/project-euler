# Problem 1: Multiple of 3 and 5
#
# Find the sum of all the multiples of 3 or 5 below 1000.
#
# See https://projecteuler.net/problem=1
def run(limit=1_000) -> int:
    return sum([n for n in range(limit) if n % 3 == 0 or n % 5 == 0])


def test_run():
    assert run() == 233168
