from core import irange

a = sum(map(lambda i: i * i, irange(100)))
b = sum(irange(100))
print b * b - a
