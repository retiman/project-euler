# Problem 31: Coin Sums
#
# How many different ways can £2 be made using any number of coins?
#
# See https://projecteuler.net/problem=31
import functools
from typing import Callable


def run() -> int:
    P: dict[int, Callable[[int], int]] = {}

    # Number of ways to make change for n using coins of value 1p.
    P[1] = lambda n: 1 if n >= 0 else 0

    # Generate P[x] for x = 2, 5, 10, 20, 50, 100.  Each function P[xk] can be created based previous values of xk.
    def define_px(x, y):
        # Number of ways to make change for n using coins of value x or less.
        @functools.lru_cache(maxsize=None)
        def px(n):
            # Get the function that computes ways to make change for n using y or less.
            py = P[y]

            # Number of ways to make change for n using a higher denomination of coin (x).
            cx = px(n - x) if n >= x else 0

            # Number of ways to make change for n using a lower denomination of coin (y).
            cy = py(n)

            return cx + cy

        # Now that px(n) has been defined, store it in the dictionary.
        P[x] = px

    # Define function that computes ways to make change for n using 2p and 1p.
    define_px(2, 1)
    # Define function that computes ways to make change for n using 5p, 2p, and 1p.
    define_px(5, 2)
    # Define function that computes ways to make change for n using 10p, 5p, 2p, and 1p.
    define_px(10, 5)
    # Define function that computes ways to make change for n using 20p, 10p, 5p, 2p, and 1p.
    define_px(20, 10)
    # Define function that computes ways to make change for n using 50p, 20p, 10p, 5p, 2p, and 1p.
    define_px(50, 20)
    # Define function that computes ways to make change for n using £1, 50p, 20p, 10p, 5p, 2p, and 1p.
    define_px(100, 50)
    # Define function that computes ways to make change for n using £2, £1, 50p, 20p, 10p, 5p, 2p, and 1p.
    define_px(200, 100)

    # Get the function that computes ways to make change for £2.
    p200 = P[200]
    return p200(200)


def test_run():
    assert run() == 73682
