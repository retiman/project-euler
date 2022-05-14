IMAGE := 3.0.0-slim-buster

%: %.rb
ifeq ("$(wildcard /.dockerenv)","")
	docker run \
		--pull missing \
		--rm \
		--volume "${CURDIR}:/src:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /src \
		ruby:${IMAGE} \
		ruby $<
else
	ruby $<
endif
