IMAGE := 3.9.2-slim-buster
PWD := $(shell pwd)

%: %.py
	docker run \
		--pull missing \
		--volume "${PWD}:/src" \
		--volume "${PWD}/../data:/data" \
		--workdir /src \
		python:${IMAGE} \
		python $<
