IMAGE := 8.0-full
.PHONY = repl

repl:
	$(MAKE) -C lib repl

%: %.rkt
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src" \
		--volume "${CURDIR}/../data:/data" \
		--workdir /src \
		racket/racket:${IMAGE} \
		/bin/bash -c "chmod +x ./$*.rkt && ./$*.rkt"
