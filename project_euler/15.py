# Problem 15: Lattice Paths
#
# How many paths are there through a 20x20 grid?
#
# See https://projecteuler.net/problem=15
import math


def run():
    # It's not necessary to actually generate the routes; we can count them directly. Starting at the upper left, one
    # must move down exactly 20 times, and right exactly 20 times in order to reach the bottom right. Represent the
    # downward movement as a 'D' and the rightward movement as an 'R', then the number of routes to the bottom right is
    # equal to the number of permutations of a 'word' with 20 D's and 20 R's.
    #
    # This can be viewed as a multiset permutation whose cardinality is the multinomial coefficient: (20 + 20)! / 20!20!
    # You can compute this as math.comb(20 + 20, 20).
    return math.comb(20 + 20, 20)


def test_run():
    assert run() == 137846528820
