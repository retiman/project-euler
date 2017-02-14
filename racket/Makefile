.PHONY: all test

all: test

%: %.rkt
	time racket -r $<

repl:
	racket -i -e '(enter! "lib/repl.rkt")'

test:
	racket -f test/tests.rkt
