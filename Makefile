CLOJURE ?= $(if $(shell which clj), clj, clojure)
LIMIT := 1e8

stats:
	data/scripts/stats.sh

primes:
	${CLOJURE} -e "(use '[clojure.contrib.lazy-seqs :only (primes)]) (doseq [p (take-while #(< % ${LIMIT}) primes)] (println p))" > data/primes.txt
