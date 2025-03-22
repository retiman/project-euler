# Problem 13: Large Sum
#
# Work out the first ten digits of the sum of the one-hundred 50 digit numbers.
#
# See https://projecteuler.net/problem=13
from pathlib import Path


def run():
    file = Path(__file__).parent / "data" / "13.txt"
    xs = [int(x) for x in file.read_text().splitlines()]
    value = str(sum(xs))
    return int(value[:10])


def test_run():
    assert run() == 5537376230
