# Problem 19: Counting Sundays
#
# How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
#
# See https://projecteuler.net/problem=19
from datetime import date

def run() -> int:
    count = 0
    for year in range(1901, 2001):
        for month in range(1, 13):
            if date(year, month, 1).weekday() == 6:
                count += 1
    return count


def test_run():
    assert run() == 171