IMAGE := 8.0-full

%: %.rkt
	docker run \
		--pull missing \
		--rm \
		--volume "${PWD}:/src" \
		--volume "${PWD}/../data:/data" \
		--workdir /src \
		racket/racket:${IMAGE} \
		/bin/bash -c "chmod +x ./$*.rkt && ./$*.rkt"
