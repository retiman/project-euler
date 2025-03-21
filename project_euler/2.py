from itertools import takewhile
from typing import cast
from toolz import curried, pipe


def fibs():
    a, b = 0, 1
    while True:
        yield a
        a, b = b, a + b


def run(limit: int) -> int:
    result = pipe(
        fibs(),
        lambda xs: takewhile(lambda x: x < limit, xs),
        curried.filter(lambda x: x % 2 == 0),
        curried.reduce(lambda a, b: a + b),
    )
    return cast(int, result)


def test_run():
    assert run(4_000_000) == 4613732
