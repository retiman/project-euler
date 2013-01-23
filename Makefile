all: stats

stats:
	data/scripts/stats.sh

primes:
	wget -O data/primes.txt.gz https://github.com/downloads/retiman/project-euler/primes.txt.gz
	gunzip data/primes.txt.gz
