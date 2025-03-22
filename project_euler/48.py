# Problem 48: Self powers.
#
# Computes the last ten digits of the series 1^1 + 2^2 + 3^3 + ... + 1000^1000.
#
# See https://projecteuler.net/problem=48
from typing import cast
from toolz import curried, pipe


def run(n=1_000) -> int:
    # This modulus will give us the last 10 digits.
    m = 10**10
    result = pipe(
        range(1, n + 1),
        curried.map(lambda b: pow(b, b, m)),
        curried.reduce(lambda a, b: (a + b) % m),
    )
    return cast(int, result)


def test_run():
    assert run() == 9110846700
