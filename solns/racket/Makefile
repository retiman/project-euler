IMAGE := 7.9-full

.PHONY = repl
repl:
	$(MAKE) -C lib repl

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
