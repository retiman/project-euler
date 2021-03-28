IMAGE := 3.0.0-slim-buster

%: %.rb
	docker run \
		--pull missing \
		--volume "${CURDIR}:/src" \
		--volume "${CURDIR}/../data:/data" \
		--workdir /src \
		ruby:${IMAGE} \
		ruby $<
