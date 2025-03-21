from project_euler.common.totient import totient


def test_totient():
    assert totient(1) == 0
    assert totient(7) == 6
    assert totient(15) == 8
    assert totient(2015) == 1440
