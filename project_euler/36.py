# Problem 36: Double-base Palindromes
#
# Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
#
# See https://projecteuler.net/problem=36
def is_palindrome(s: str) -> bool:
    return s == s[::-1]


def is_double_base_palindrome(n: int) -> bool:
    base_10 = str(n)
    base_2 = bin(n)[2:]
    return is_palindrome(base_10) and is_palindrome(base_2)


def run(limit = 1_000_000) -> int:
    return sum(n for n in range(limit + 1) if is_double_base_palindrome(n))


def test_run():
    assert run() == 872187
