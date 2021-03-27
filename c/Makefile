IMAGE := 10.2.0
PWD := $(shell pwd)

%: %.c
	docker run \
		--pull missing \
		--rm \
		--volume "${PWD}:/src" \
		--volume "${PWD}/../data:/data" \
		--workdir /src \
		gcc:${IMAGE} \
		/bin/bash -c "gcc $*.c && ./a.out && rm a.out"
