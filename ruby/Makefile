PWD=$(shell pwd)
IMAGE=3.0.0-slim-buster

%: %.rb
	docker run \
		--pull missing \
		--volume "$(PWD):/src" \
		--volume "$(PWD)/../data:/data" \
		--workdir /src \
		ruby:$(IMAGE) \
		ruby $<
