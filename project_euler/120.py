# Problem 120: Square Remainders
#
# See https://projecteuler.net/problem=120
def r_max(a: int) -> int:
    return 2 * a * ((a - 1) // 2)


def run(limit=1_000) -> int:
    return sum(r_max(a) for a in range(3, limit + 1))


def test_run():
    assert run() == 333082500
