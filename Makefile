all: primes

stats:
	data/scripts/stats.sh

primes:
	wget -O data/primes.txt.gz https://github.com/downloads/retiman/project-euler/primes.txt.gz
	gunzip data/primes.txt.gz

genprimes:
	clj clojure/lib/primes.clj 100000000
