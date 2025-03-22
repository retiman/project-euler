from project_euler.common.order import ord


def test_ord():
    assert ord(4, 7) == 3
    assert ord(10, 7) == 6
    assert ord(5, 3) == 2
    assert ord(13, 7) == 2
    assert ord(3, 20) == 4
    assert ord(3, 115) == 44
