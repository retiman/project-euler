PYTHON = /usr/bin/env python

all: primes

stats:
	scripts/stats.sh

primes:
	$(PYTHON) scripts/primes.py 5000000 > data/primes.txt

generate:
	$(PYTHON) scripts/primes.py $(LIMIT) > data/primes.txt
