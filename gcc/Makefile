IMAGE := 10.2.0

%: %.c
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src" \
		--volume "${CURDIR}/../.data:/data" \
		--workdir /src \
		gcc:${IMAGE} \
		/bin/bash -c "gcc $*.c && ./a.out && rm a.out"
