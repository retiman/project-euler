IMAGE := 10.2.0

%: %.c
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /src \
		gcc:${IMAGE} \
		/bin/bash -c "gcc $*.c -o /tmp/soln && /tmp/soln && rm /tmp/soln"
