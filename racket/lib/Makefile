IMAGE := 8.0-full
.PHONY: repl test

primes:
	docker run \
		--pull missing \
		--tty \
		--volume "${PWD}/../../data:/data" \
		--volume "${PWD}:/src" \
		--workdir /src \
		racket/racket:${IMAGE} \
		/bin/bash -c "./primes.rkt 5000000 > /data/primes.txt"

repl:
	docker run \
		--pull missing \
		--interactive \
		--tty \
		--rm \
		--volume "${PWD}/../../data:/data" \
		--volume "${PWD}:/src" \
		--workdir /src \
		racket/racket:${IMAGE} \
		racket -i -e '(enter! "repl.rkt")'

test:
	docker run \
		--pull missing \
		--rm \
		--volume "${PWD}:/src" \
		--workdir /src \
		racket/racket:${IMAGE} \
		racket -f tests.rkt
