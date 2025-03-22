# Problem 32: Pandigital Products
#
# Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9
# pandigital.
#
# See https://projecteuler.net/problem=32
from itertools import permutations


def tuple2int(cs: tuple[str, ...]) -> int:
    return int("".join(cs))


def pandigital_product_values(p: tuple[str, ...], i: int, j: int) -> tuple[int, int, int]:
    a = tuple2int(p[:i])
    b = tuple2int(p[i : i + j])
    c = tuple2int(p[i + j :])
    return (a, b, c)


def run():
    seen: set[int] = set()
    products: set[int] = set()

    for p in permutations("123456789"):
        # Check form: a * bcde = fghi (1 digit × 4 digits = 4 digits)
        (a, b, c) = pandigital_product_values(p, 1, 4)
        if c not in seen and c == a * b:
            products.add(c)
            seen.add(c)

        # Check form: ab * cde = fghi (2 digits × 3 digits = 4 digits)
        (a, b, c) = pandigital_product_values(p, 2, 3)
        if c not in seen and c == a * b:
            products.add(c)
            seen.add(c)

    return sum(products)


def test_run():
    assert run() == 45228
