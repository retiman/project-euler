IMAGE := 8.0-full
.PHONY = repl

repl:
	$(MAKE) -C lib repl

%: %.rkt
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /src \
		racket/racket:${IMAGE} \
		racket $*.rkt

