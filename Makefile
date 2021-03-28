all: primes

primes:
	$(MAKE) -C racket/lib primes

repl:
	$(MAKE) -C racket/lib repl

test:
	$(MAKE) -C racket/lib test
