IMAGE=3.0.0-slim-buster
PWD=$(shell pwd)

%: %.rb
	docker run \
		--pull missing \
		--volume "${PWD}:/src" \
		--volume "${PWD}/../data:/data" \
		--workdir /src \
		ruby:${IMAGE} \
		ruby $<
