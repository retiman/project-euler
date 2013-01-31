from core import irange
print(sum(n for n in irange(1000) if n % 3 == 0 or n % 5 == 0))
