# Problem 9: Special Pythagorean Triplet
#
# There exists exactly one Pythagorean triplet for which a + b + c = 1000.  Find the product a * b * c.
#
# See https://projecteuler.net/problem=9
def run(limit: int) -> int:
    # Limit search space for a; since b and c are greater than a, the maximum value for a is 1/3 of the target.
    a_max = limit // 3
    for a in range(1, a_max):
       # Limit search space for b; since c is greater than b, the maximum value for b is half the remaining value.
       b_max = (limit -a ) // 2
       for b in range(a + 1, b_max):
           c = limit - a - b

           if a * a + b * b == c * c:
               return a * b * c

    raise ValueError("no triplet found")


def test_run():
    assert run(1000) == 31875000

