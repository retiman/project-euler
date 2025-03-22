# Problem 30: Digit Fifth Powers
#
# Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
#
# See https://projecteuler.net/problem=30
def digital_sum(n: int) -> int:
    return sum(int(d) ** 5 for d in str(n))


def run() -> int:
    x = 9**5

    digits = 1
    while 10 ** (digits - 1) <= digits * x:
        digits += 1

    limit = digits * x
    result = sum(i for i in range(10, limit) if i == digital_sum(i))
    return result


def test_run():
    assert run() == 443839
