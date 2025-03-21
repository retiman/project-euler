# Problem 16: Power Digit Sum
#
# What is the sum of the digits of the number 2^1000?
#
# See https://projecteuler.net/problem=16
def run():
    s = str(2**1000)
    return sum(int(c) for c in s)


def test_run():
    assert run() == 1366
