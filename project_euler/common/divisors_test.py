from project_euler.common.divisors import divisors


def test_divisors():
    assert divisors(1) == [1]
    assert divisors(2) == [1, 2]
    assert divisors(15) == [1, 3, 5, 15]
    assert divisors(2015) == [1, 5, 13, 31, 65, 155, 403, 2015]
