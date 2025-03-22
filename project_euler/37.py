# Problem 37: Truncatable Primes
#
# Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
#
# See https://projecteuler.net/problem=37
from project_euler.common.primes import is_prime


def truncate(n: int, direction: str) -> int:
    s = str(n)

    if direction == "L":
        return int(s[1:])
    elif direction == "R":
        return int(s[:-1])

    raise ValueError("invalid direction")


def is_truncatable(n: int, direction: str) -> bool:
    if not is_prime(n):
        return False

    if n < 10:
        return True

    return is_truncatable(truncate(n, direction), direction)


def is_fully_truncatable(n: int) -> bool:
    return is_truncatable(n, "L") and is_truncatable(n, "R")


def run(limit=11) -> list[int]:
    result: list[int] = []

    # Exclude 2, 3, 5, and 7; they are not truncatable.
    p = 11
    while len(result) < limit:
        if is_fully_truncatable(p):
            result.append(p)

        # Exclude even numbers; they cannot be prime.
        p += 2

    return sum(result)


def test_run():
    assert run() == 748317
