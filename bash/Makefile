IMAGE := 10.8-slim

%: %.sh
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src" \
		--volume "${CURDIR}/../data:/data" \
		--workdir /src \
		debian:${IMAGE} \
		bash $<
