from project_euler.common.modular_tetration import hpow


def test_modular_tetration():
    assert hpow(3, 1, 2) == 3**1 % 2
    assert hpow(3, 2, 20) == 3**3 % 20
    assert hpow(3, 3, 345) == 312
    assert hpow(5, 2, 7) == 5**5 % 7
    assert hpow(7, 4, 13) == 6
    assert hpow(10, 2, 6) == 10**10 % 6
