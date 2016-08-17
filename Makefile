all: stats

stats:
	scripts/stats.sh

primes:
	scripts/primes.rkt 5000000 > data/primes.txt

generate:
	scripts/primes.rkt $(LIMIT) > data/primes.txt
