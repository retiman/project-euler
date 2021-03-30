IMAGE := 10.8-slim

%: %.sh
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /src \
		debian:${IMAGE} \
		bash $<
