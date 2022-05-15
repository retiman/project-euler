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
		--volume "${CURDIR}:/workspace:ro" \
		--volume "${CURDIR}/../../data:/data:ro" \
		--workdir /workspace \
		ruby:${IMAGE} \
		ruby $<
else
	ruby $<
endif
