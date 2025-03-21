# Problem 21: Amicable Numbers
#
# Evaluate the sum of all the amicable numbers under 10_000.
#
# See https://projecteuler.net/problem=21
from project_euler.common.divisors import sigma


def run(n: int) -> int:
    result = 0

    for a in range(2, n + 1):
        b = sigma(a) - a
        if a > b and sigma(b) - b == a:
            result += a + b

    return result


def test_run():
    assert run(10_000) == 31626