IMAGE := 3.0.0-slim-buster

%: %.rb
# Docker creates a /.dockerenv file if running in a container.  Without this file we can assume we need to pull and
# start the image.
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
