from core import irange
from functools import reduce

def is_palindrome(s):
    return s == s[::-1]

def gen():
    for i in irange(999, 1, -1):
        for j in irange(i, 1, -1):
            s = i * j
            if is_palindrome(str(s)):
                yield s

print reduce(max, gen())
