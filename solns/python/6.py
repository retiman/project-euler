a = sum(map(lambda i: i * i, range(101)))
b = sum(range(101))
result = b * b - a

print(result)
assert(result == 25164150)
