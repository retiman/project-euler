# Problem 40: Champernowne's Constant
#
# Find the product of the digits at the following positions in Champernowne's constant:
#
# 1, 10, 100, 1000, 10000, 100000, 1000000.
#
# See https://projecteuler.net/problem=40
def generate_champernownes_constant(limit: int) -> str:
    s = ""
    n = 1

    while len(s) < limit:
        s += str(n)
        n += 1

    return s


def run(limit: int) -> int:
    s = generate_champernownes_constant(limit)

    result = 1
    for i in [10**k for k in range(7)]:
        digit = int(s[i - 1])
        result *= digit

    return result


def test_run():
    assert run(1_000_000) == 210
