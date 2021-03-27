.PHONY := image
IMAGE := 5.3-debian10.8-slim
PWD := $(shell pwd)

# NOTE: There is no official image.  We'll have to build it ourselves.
# https://github.com/docker-library/official-images/issues/3404
image:
	docker build --tag retiman/lua:${IMAGE} .

%: %.lua
	docker run \
		--rm \
		--volume "${PWD}:/src" \
		--volume "${PWD}/../data:/data" \
		--workdir /src \
		retiman/lua:${IMAGE} \
		lua $<
