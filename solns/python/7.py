primes = 0
for line in open("../data/primes.txt", "r"):
    primes += 1
    if primes == 10001:
        result = int(line)
        break

print(result)
assert result == 104743
