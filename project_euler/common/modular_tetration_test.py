from project_euler.common.modular_tetration import mtetn


def test_modular_tetration():
    assert mtetn(3, 1, 2) == 3**1 % 2
    assert mtetn(3, 2, 20) == 3**3 % 20
    assert mtetn(3, 3, 345) == 312
    assert mtetn(5, 2, 7) == 5**5 % 7
    assert mtetn(7, 4, 13) == 6
    assert mtetn(10, 2, 6) == 10**10 % 6
