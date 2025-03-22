# Problem 4: Largest Palindrome Product
#
# Find the largest palindrome made from the product of two 3-digit numbers.
#
# See https://projecteuler.net/problem=4
def is_palindrome(n):
    return str(n) == str(n)[::-1]


def run():
    max_product = 0

    # To speed up the search, we can limit the search space and search backwards.  We want to find the largest
    # palindrome, so we start with the largest numbers first.
    for i in range(999, 99, -1):
        for j in range(999, 99, -1):
            n = i * j
            if is_palindrome(n) and n > max_product:
                max_product = n

    return max_product


def test_run():
    assert run() == 906609
