IMAGE := 8.0-full
.PHONY: repl test

primes:
	docker run \
		--pull missing \
		--tty \
		--volume "${CURDIR}/../../../data:/data" \
		--volume "${CURDIR}:/src" \
		--workdir /src \
		--user $(shell id -u):$(shell id -g) \
		racket/racket:${IMAGE} \
		/bin/bash -c "racket primes.rkt 5000000 > /data/primes.txt"

repl:
	docker run \
		--pull missing \
		--interactive \
		--tty \
		--rm \
		--volume "${CURDIR}/../../../data:/data" \
		--volume "${CURDIR}:/src" \
		--workdir /src \
		racket/racket:${IMAGE} \
		racket -i -e '(enter! "repl.rkt")'

test:
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src" \
		--workdir /src \
		racket/racket:${IMAGE} \
		racket tests.rkt
