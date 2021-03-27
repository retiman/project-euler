from itertools import takewhile

def fibs():
    a, b = 0, 1
    while True:
        yield b
        a, b = b, a + b

xs = fibs()
result = sum(filter(lambda x: x % 2 == 0, takewhile(lambda x: x < 4000000, xs)))

print(result)
assert(result == 4613732)
