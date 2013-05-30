PYTHON ?= $(if $(shell which python2), python2, python)

all: download-primes

stats:
	scripts/stats.sh

download-primes:
	wget -O data/primes.txt.gz https://github.com/downloads/retiman/project-euler/primes.txt.gz
	gunzip data/primes.txt.gz

primes:
	$(PYTHON) scripts/primes.py $(LIMIT) > data/primes.txt
