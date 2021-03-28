IMAGE := 8.0-full

%: %.rkt
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src" \
		--volume "${CURDIR}/../.data:/data" \
		--workdir /src \
		racket/racket:${IMAGE} \
		/bin/bash -c "chmod +x ./$*.rkt && ./$*.rkt"
