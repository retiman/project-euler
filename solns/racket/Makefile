IMAGE := 7.9-full

# racket-review can only take one file as an argument
define review
	raco review $1;
endef

.PHONY = deps
deps:
	raco pkg install review

.PHONY = lint
lint:
	$(foreach file,$(wildcard *.rkt),$(call review,$(file)))
	$(foreach file,$(wildcard lib/*.rkt),$(call review,$(file)))

.PHONY = primes
primes:
	docker run \
		--pull missing \
		--tty \
		--volume "${CURDIR}/../../data:/data" \
		--volume "${CURDIR}:/workspace" \
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
		--volume "${CURDIR}/../../data:/data" \
		--volume "${CURDIR}:/workspace" \
		--workdir /workspace \
		racket/racket:${IMAGE} \
		racket -i -e '(enter! "lib/repl.rkt")'

.PHONY = test
test:
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}/../../data:/data" \
		--volume "${CURDIR}:/workspace" \
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
