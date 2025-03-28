# Problem 29: Distinct Powers
#
# How many distinct terms are in the sequence generated by a^b for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100?
#
# See https://projecteuler.net/problem=29
def run() -> int:
    terms: set[int] = set()
    for a in range(2, 101):
        for b in range(2, 101):
            terms.add(a**b)

    return len(terms)


def test_run():
    assert run() == 9183
