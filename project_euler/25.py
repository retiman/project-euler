# Problem 25: 1000-digit Fibonacci Number
#
# What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
#
# See https://projecteuler.net/problem=25
from project_euler.common.fibonacci_numbers import fibs


def run() -> int:
    for i, n in enumerate(fibs()):
        count = len(str(n))
        if count >= 1000:
            return i


def test_run():
    assert run() == 4782