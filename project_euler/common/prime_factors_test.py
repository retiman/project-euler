from project_euler.common.prime_factors import prime_factors


def test_prime_factors():
    assert prime_factors(1) == []
    assert prime_factors(2) == [2]
    assert prime_factors(27) == [3]
    assert prime_factors(2015) == [5, 13, 31]
    assert prime_factors(2310) == [2, 3, 5, 7, 11]
    assert prime_factors(103243) == [7, 43]
