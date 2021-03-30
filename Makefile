all: primes test

primes:
	$(MAKE) -C solns/racket/lib primes

repl:
	$(MAKE) -C solns/racket/lib repl

test:
	$(MAKE) -C solns/racket/lib test
