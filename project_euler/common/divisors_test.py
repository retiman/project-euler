import numpy as np
from project_euler.common.divisors import divisors


def test_divisors():
    assert np.array_equal(divisors(1), [1])
    assert np.array_equal(divisors(2), [1, 2])
    assert np.array_equal(divisors(15), [1, 3, 5, 15])
    assert np.array_equal(divisors(2015), [1, 5, 13, 31, 65, 155, 403, 2015])
