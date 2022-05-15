IMAGE := 7.9-full

.PHONY = primes
primes:
	docker run \
		--pull missing \
		--tty \
		--volume "${CURDIR}/../../data:/data:rw" \
		--volume "${CURDIR}:/workspace:ro" \
		--workdir /workspace \
		--user $(shell id -u):$(shell id -g) \
		racket/racket:${IMAGE} \
		/bin/bash -c "racket lib/primes.rkt 5000000 > /data/primes.txt"

.PHONY = repl
repl:
	docker run \
		--pull missing \
		--interactive \
		--tty \
		--rm \
		--volume "${CURDIR}/../../data:/data:ro" \
		--volume "${CURDIR}:/workspace:ro" \
		--workdir /workspace \
		racket/racket:${IMAGE} \
		racket -i -e '(enter! "lib/repl.rkt")'

.PHONY = test
test:
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}/../../data:/data:ro" \
		--volume "${CURDIR}:/workspace:ro" \
		--workdir /workspace/lib \
		racket/racket:${IMAGE} \
		racket tests.rkt

%: %.rkt
ifeq ("$(wildcard /.dockerenv)","")
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/workspace:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /workspace \
		racket/racket:${IMAGE} \
		racket $*.rkt
else
	racket $*.rkt
endif
