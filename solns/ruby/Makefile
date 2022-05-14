IMAGE := 3.1.2-slim-buster

deps:
	bundle install

lint:
	rubocop --auto-correct-all

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
