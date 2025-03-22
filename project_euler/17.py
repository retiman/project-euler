# Problem 17: Number Letter Counts
#
# If all the numbers from 1 to 1000 inclusive were written out in words, how many letters would be used?
#
# See https://projecteuler.net/problem=17
MAPPING = {
    1: "one",
    2: "two",
    3: "three",
    4: "four",
    5: "five",
    6: "six",
    7: "seven",
    8: "eight",
    9: "nine",
    10: "ten",
    11: "eleven",
    12: "twelve",
    13: "thirteen",
    14: "fourteen",
    15: "fifteen",
    16: "sixteen",
    17: "seventeen",
    18: "eighteen",
    19: "nineteen",
    20: "twenty",
    30: "thirty",
    40: "forty",
    50: "fifty",
    60: "sixty",
    70: "seventy",
    80: "eighty",
    90: "ninety",
}


def say(n: int) -> str:
    if n == 1000:
        return "one thousand"
    elif n >= 100 and n % 100 != 0:
        key = n // 100
        return f"{MAPPING[key]} hundred and {say(n % 100)}"
    elif n >= 100:
        key = n // 100
        return f"{MAPPING[key]} hundred"
    elif n >= 20 and n % 10 != 0:
        key = n - (n % 10)
        return f"{MAPPING[key]} {say(n % 10)}"
    else:
        return MAPPING[n]


def run():
    result = 0
    for i in range(1, 1001):
        result += len(say(i).replace(" ", ""))
    return result


def test_run():
    assert run() == 21124
