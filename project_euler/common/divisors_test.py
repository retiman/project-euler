from project_euler.common.divisors import divisors, sigma, tau


def test_divisors():
    assert divisors(1) == [1]
    assert divisors(2) == [1, 2]
    assert divisors(15) == [1, 3, 5, 15]
    assert divisors(2015) == [1, 5, 13, 31, 65, 155, 403, 2015]


def test_sigma():
    assert sigma(1) == 1
    assert sigma(2) == 3
    assert sigma(15) == 24
    assert sigma(2015) == 2688


def test_tau():
    assert tau(1) == 1
    assert tau(2) == 2
    assert tau(15) == 4
    assert tau(2015) == 8
