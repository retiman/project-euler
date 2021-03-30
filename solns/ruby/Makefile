IMAGE := 3.0.0-slim-buster

%: %.rb
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /src \
		ruby:${IMAGE} \
		ruby $<
