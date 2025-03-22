# Problem 23: Non-Abundant Sums
#
# Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
#
# See https://projecteuler.net/problem=23
from project_euler.common.divisors import sigma


def run(limit: int) -> int:
    abundants = list(filter(lambda n: sigma(n) - n > n, range(1, limit + 1)))
    numbers = list(range(0, limit + 1))

    for i in range(len(abundants)):
        for j in range(i, len(abundants)):
            k = abundants[i] + abundants[j]
            if k <= limit:
                numbers[k] = 0
            else:
                break

    return sum(numbers)


def test_run():
    assert run(28123) == 4179871
