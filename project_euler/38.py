# Problem 38: Pandigital Multiples
#
# What is the largest 1 to 9 pandigital 9 digit number that can be formed as the concatenated product of an integer with
# (1,2, ... , n) where n > 1?
#
# See https://projecteuler.net/problem=38
from itertools import permutations


def create_pandigitals() -> set[int]:
    return set(int("".join(p)) for p in permutations("123456789"))


def pandigital_product(pandigitals: set[int], n: int) -> int:
    s = ""
    i = 1

    while len(s) < 9:
        s += str(n * i)
        i += 1

    return int(s) if len(s) == 9 and (int(s) in pandigitals) and i > 2 else 0


def run() -> int:
    pandigitals = create_pandigitals()
    products = [pandigital_product(pandigitals, n) for n in range(1, 9999)]
    return max(products)


def test_run():
    assert run() == 932718654
