from functools import reduce


def is_palindrome(s):
    return s == s[::-1]


def gen():
    for i in range(1000, 1, -1):
        for j in range(i + 1, 1, -1):
            s = i * j
            if is_palindrome(str(s)):
                yield s


result = reduce(max, gen())

print(result)
assert result == 906609
