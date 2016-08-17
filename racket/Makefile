.PHONY: all test

all: test

%: %.rkt
	time racket -r $<

test:
	racket -f test/tests.rkt
